using System.Windows.Forms;
using System.Text;

namespace Catering
{
    public partial class CateringForm : Form
    {
        String name = "none";
        String phoneNum = "none";
        int guests = 0;
        String entree = "none";
        String desert = "none";
        String[] sides = {"too many sides chosen!"};
        int cost = 0;
        public CateringForm()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            var items = SlidesListBox.Items;
            items.Add("Cheese Sticks");
            items.Add("Apple Sauce");
            items.Add("Macaroni and Cheese");
            items.Add("Pickel Chips");

            var deserts = DesertDropBox.Items;
            deserts.Add("Lava Cake");
            deserts.Add("Chocolate Cake");
            deserts.Add("30 lb of Brownies");

            var Entrees = EntreeDropBox.Items;
            Entrees.Add("Godly Burgers");
            Entrees.Add("Zeus's Thunderbolt");
            Entrees.Add("Angel's kiss");
            Entrees.Add("Chicken Strips");
        }

        private void PhoneNumTextBox_TextChanged(object sender, EventArgs e)
        {
            phoneNum = PhoneNumTextBox.Text;
        }

        private void TextBoxName_TextChanged_1(object sender, EventArgs e)
        {
            name = TextBoxName.Text;
        }

        private void GuestTextBox_TextChanged(object sender, EventArgs e)
        {
            try
            {
                guests = Int32.Parse(GuestTextBox.Text);
                cost = 35 * guests + 35;
            }
            catch
            {
                cost = 0;
            }

        }

        private void EntreeDropBox_SelectedIndexChanged(object sender, EventArgs e)
        {
            entree = EntreeDropBox.GetItemText(EntreeDropBox.SelectedItem);
        }

        private void SlidesListBox_SelectedIndexChanged(object sender, EventArgs e)
        {
  
        }

        private void DesertDropBox_SelectedIndexChanged(object sender, EventArgs e)
        {
            desert = DesertDropBox.GetItemText(DesertDropBox.SelectedItem);
        }

        private void FinishButton_Click(object sender, EventArgs e)
        {
            if (SlidesListBox.CheckedItems.Count <= 2)
            {
                String[] temp = new String[SlidesListBox.CheckedItems.Count];
                sides = temp;

                int i = 0;
                foreach (object itemChecked in SlidesListBox.CheckedItems)
                {
                    if (itemChecked is null)
                    {
                        sides[0] = "none";
                    }
                    else
                    {
                        sides[i] = itemChecked.ToString();
                        i++;
                    }
                }
            }

            string path = Environment.GetFolderPath(Environment.SpecialFolder.Desktop);
            using (StreamWriter outputFile = new StreamWriter(Path.Combine(path, "Event.txt")))
            {
                outputFile.WriteLine("Name: " + name);
                outputFile.WriteLine("Phone Number: " + phoneNum);
                outputFile.WriteLine("Number of guests: " + guests);
                outputFile.WriteLine("Entree: " + entree);
                outputFile.Write("Sides: ");

                
                foreach (String side in sides)
                {
                    if(side == null)
                    {
                        //skip
                    }
                    else if(!side.Equals(""))
                    {
                        outputFile.Write(side + ", ");
                    }                 
                }
                outputFile.WriteLine();
                outputFile.WriteLine("Desert: " + desert);
                outputFile.WriteLine();
                outputFile.WriteLine("Cost: " + cost);

            }
        }
    }
}