import json

# Time it'd take for a full loop in game ticks.
TIME = 360


def calculate_x(hue: int) -> float:
	x = 1 - abs((hue / 60) % 2 - 1)
	return x


def main():
	interval = round(TIME / 360)
	interval = interval or 1
	# Don't even fucking ask what "interval or 1" means...
	change = round(360 / TIME)
	change = change or 1

	power = {
		"type":     "origins:multiple",
		"hue":      {
			"type":       "origins:resource",
			"min":        0,
			"max":        359,
			"hud_render": {
				"should_render": False
			}
		},
		"hue_loop": {
			"type":          "origins:action_over_time",
			"entity_action": {
				"type":        "origins:if_else",
				"condition":   {
					"type":       "origins:resource",
					"resource":   "*:*_hue",
					"comparison": "==",
					"compare_to": 359
				},
				"if_action":   {
					"type":      "origins:change_resource",
					"resource":  "*:*_hue",
					"change":    0,
					"operation": "set"
				},
				"else_action": {
					"type":     "origins:change_resource",
					"resource": "*:*_hue",
					"change":   change
				}
			},
			"interval":      interval
		}
	}

	for hue in range(0, 360, change):
		# x: "Intermediate value depending on hue"
		x = calculate_x(hue)
		if 0 <= hue < 60:
			r, g, b = (1, x, 0)
		elif 60 <= hue < 120:
			r, g, b = (x, 1, 0)
		elif 120 <= hue < 180:
			r, g, b = (0, 1, x)
		elif 180 <= hue < 240:
			r, g, b = (0, x, 1)
		elif 240 <= hue < 300:
			r, g, b = (x, 0, 1)
		elif 300 <= hue < 360:
			r, g, b = (1, 0, x)
		else:
			print("Challenge Complete!")
			print("How Did We Get Here?")
			return

		sub_power = {
			"type":      "origins:model_color",
			"red":       r,
			"green":     g,
			"blue":      b,
			"condition": {
				"type":       "origins:resource",
				"resource":   "*:*_hue",
				"comparison": "==",
				"compare_to": hue
			}
		}

		power[f"hue-{hue}"] = sub_power

	with open('output.json', 'w', encoding='utf-8') as f:
		json.dump(power, f, indent='\t', ensure_ascii=False)


if __name__ == '__main__':
	main()
