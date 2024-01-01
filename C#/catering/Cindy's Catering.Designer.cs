namespace Catering
{
    partial class CateringForm
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            NameLabel = new Label();
            TextBoxName = new TextBox();
            PhoneNumLabel = new Label();
            PhoneNumTextBox = new TextBox();
            GuestLabel = new Label();
            EntreeLabel = new Label();
            GuestTextBox = new TextBox();
            EntreeDropBox = new ComboBox();
            SidesLabel = new Label();
            SlidesListBox = new CheckedListBox();
            DesertLabel = new Label();
            DesertDropBox = new ComboBox();
            FinishButton = new Button();
            SuspendLayout();
            // 
            // NameLabel
            // 
            NameLabel.AutoSize = true;
            NameLabel.Location = new Point(49, 15);
            NameLabel.Name = "NameLabel";
            NameLabel.Size = new Size(49, 20);
            NameLabel.TabIndex = 2;
            NameLabel.Text = "Name";
            // 
            // TextBoxName
            // 
            TextBoxName.Location = new Point(155, 11);
            TextBoxName.Name = "TextBoxName";
            TextBoxName.Size = new Size(175, 27);
            TextBoxName.TabIndex = 3;
            TextBoxName.TextChanged += TextBoxName_TextChanged_1;
            // 
            // PhoneNumLabel
            // 
            PhoneNumLabel.AutoSize = true;
            PhoneNumLabel.Location = new Point(24, 55);
            PhoneNumLabel.Name = "PhoneNumLabel";
            PhoneNumLabel.Size = new Size(108, 20);
            PhoneNumLabel.TabIndex = 4;
            PhoneNumLabel.Text = "Phone Number";
            // 
            // PhoneNumTextBox
            // 
            PhoneNumTextBox.Location = new Point(155, 51);
            PhoneNumTextBox.Name = "PhoneNumTextBox";
            PhoneNumTextBox.Size = new Size(175, 27);
            PhoneNumTextBox.TabIndex = 5;
            PhoneNumTextBox.TextChanged += PhoneNumTextBox_TextChanged;
            // 
            // GuestLabel
            // 
            GuestLabel.AutoSize = true;
            GuestLabel.Location = new Point(14, 101);
            GuestLabel.Name = "GuestLabel";
            GuestLabel.Size = new Size(128, 20);
            GuestLabel.TabIndex = 6;
            GuestLabel.Text = "Number of Guests";
            // 
            // EntreeLabel
            // 
            EntreeLabel.AutoSize = true;
            EntreeLabel.Location = new Point(49, 144);
            EntreeLabel.Name = "EntreeLabel";
            EntreeLabel.Size = new Size(51, 20);
            EntreeLabel.TabIndex = 7;
            EntreeLabel.Text = "Entree";
            // 
            // GuestTextBox
            // 
            GuestTextBox.Location = new Point(155, 97);
            GuestTextBox.Margin = new Padding(3, 4, 3, 4);
            GuestTextBox.Name = "GuestTextBox";
            GuestTextBox.Size = new Size(175, 27);
            GuestTextBox.TabIndex = 8;
            GuestTextBox.TextChanged += GuestTextBox_TextChanged;
            // 
            // EntreeDropBox
            // 
            EntreeDropBox.FormattingEnabled = true;
            EntreeDropBox.Location = new Point(155, 140);
            EntreeDropBox.Margin = new Padding(3, 4, 3, 4);
            EntreeDropBox.Name = "EntreeDropBox";
            EntreeDropBox.Size = new Size(175, 28);
            EntreeDropBox.TabIndex = 9;
            EntreeDropBox.SelectedIndexChanged += EntreeDropBox_SelectedIndexChanged;
            // 
            // SidesLabel
            // 
            SidesLabel.AutoSize = true;
            SidesLabel.Location = new Point(37, 191);
            SidesLabel.Name = "SidesLabel";
            SidesLabel.Size = new Size(98, 20);
            SidesLabel.TabIndex = 10;
            SidesLabel.Text = "Sides (max 2)";
            // 
            // SlidesListBox
            // 
            SlidesListBox.FormattingEnabled = true;
            SlidesListBox.Location = new Point(155, 191);
            SlidesListBox.Margin = new Padding(3, 4, 3, 4);
            SlidesListBox.Name = "SlidesListBox";
            SlidesListBox.Size = new Size(175, 114);
            SlidesListBox.TabIndex = 11;
            SlidesListBox.SelectedIndexChanged += SlidesListBox_SelectedIndexChanged;
            // 
            // DesertLabel
            // 
            DesertLabel.AutoSize = true;
            DesertLabel.Location = new Point(49, 339);
            DesertLabel.Name = "DesertLabel";
            DesertLabel.Size = new Size(52, 20);
            DesertLabel.TabIndex = 12;
            DesertLabel.Text = "Desert";
            // 
            // DesertDropBox
            // 
            DesertDropBox.FormattingEnabled = true;
            DesertDropBox.Location = new Point(155, 335);
            DesertDropBox.Margin = new Padding(3, 4, 3, 4);
            DesertDropBox.Name = "DesertDropBox";
            DesertDropBox.Size = new Size(175, 28);
            DesertDropBox.TabIndex = 13;
            DesertDropBox.SelectedIndexChanged += DesertDropBox_SelectedIndexChanged;
            // 
            // FinishButton
            // 
            FinishButton.Location = new Point(675, 400);
            FinishButton.Name = "FinishButton";
            FinishButton.Size = new Size(94, 29);
            FinishButton.TabIndex = 14;
            FinishButton.Text = "Finish";
            FinishButton.UseVisualStyleBackColor = true;
            FinishButton.Click += FinishButton_Click;
            // 
            // CateringForm
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 451);
            Controls.Add(FinishButton);
            Controls.Add(DesertDropBox);
            Controls.Add(DesertLabel);
            Controls.Add(SlidesListBox);
            Controls.Add(SidesLabel);
            Controls.Add(EntreeDropBox);
            Controls.Add(GuestTextBox);
            Controls.Add(EntreeLabel);
            Controls.Add(GuestLabel);
            Controls.Add(PhoneNumTextBox);
            Controls.Add(PhoneNumLabel);
            Controls.Add(TextBoxName);
            Controls.Add(NameLabel);
            Name = "CateringForm";
            Text = "CateringForm";
            Load += Form1_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label NameLabel;
        private TextBox TextBoxName;
        private Label PhoneNumLabel;
        private TextBox PhoneNumTextBox;
        private Label GuestLabel;
        private Label EntreeLabel;
        private TextBox GuestTextBox;
        private ComboBox EntreeDropBox;
        private Label SidesLabel;
        private CheckedListBox SlidesListBox;
        private Label DesertLabel;
        private ComboBox DesertDropBox;
        private Button FinishButton;
    }
}