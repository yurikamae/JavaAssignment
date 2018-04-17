README File for OOP Assignment 4. My Search Engine
Yurika Olano, C16333786

GITHUB REPO invite link: https://github.com/yurikamae/JavaAssignment/invitations

My search engine consists of 2 classes- Control and ScreenGui. I originally had 3
classes for my assignment (Control, ScreenGui and FileReader) and was going to
create a separate class to put the search engine functionalities, etc. but the
FileReader class wasn't doing anything that couldn't be written with a few lines
of code in the ScreenGui class and I was unsure of what would actually go into
a SearchEngine class so I ended up with two classes. I decided not to use a file
chooser like most people to keep my code simple and easy to follow so I have one
text file (searchwords.txt) that contains random search words that were popular
within this year and last year.

How my program works:
When you run the program, you will be presented with a screen that will contain
the title of the search engine and also a search bar, search button, search
history button and clear history button. There are also two text areas that will
display the search results(left) and search history(right). To search for a term,
clear the search bar and enter a word you desire to look for and click the search
button. If the word you entered does not match a word or phrase in the text file, 
a window will pop up to tell you that results were not found. If the word you 
entered matches a word or phrase in the text file, a window will pop up to tell 
you that results were found and when you exit out of the window, the search 
results will be displayed into the left text area. When you click the search
history button, a list of your inputs will be displayed in the right text area. 
I created separate text areas as it made it easier for me to present them this way 
and I thought it looked better to have them in separate text areas rather than 
clearing the text area to display one or the other. When the clear history button 
is clicked, all inputs will be deleted.

The only problem with the program is that it won't allow more than one word, one
letter or an incomplete word to be searched and will not display the results even 
if it exists in the text file. However, you can search for a word that is at the 
end or middle of a phrase and the whole line will be displayed, 
e.g. search "infinity" = avengers infinity war.