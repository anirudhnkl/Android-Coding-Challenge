# Android Coding Challenge

## Description of the problem and solution.

The application retrieves data from a url and displays that information with a RecyclerView in a easy to read format. The problem was to send
a GET request with the url, convert the data that was acquired with that request into a list of data objects, and then display those data objects
in a RecyclerView with an image and some text. My solution is able to do all of this.

## Workflow

I first built the RecyclerView to display the necessary information. I created a class to represent the data objects that the data acquired from 
the URL would contain. The MainActivity would contain a list of these classes. Then created an adapter and setup the RecyclerView using
this list. I used picasso to easily display the icon image.

Then I used Google's Volley requests to acquire the information with the given URL. Then I converted the JSONArray that request returns to
a list of Guide objects. After this request is over, the RecyclerView is updated.

## Technical Choices

1. I used Picasso to display the image. Picassos is very simple to use and it handles caching, and threading, with image handling on Android, without any real issue or other disadvantage.
2. I used Volley to get the information over the network. I decided to use Volley over other libraries because it can handle a lot of tasks quickly and 
it is also very easy to use. In addition, it allows you to cancel requests if needed and has a lot of other tools to debug and trace the calls if needed.

I don't think these decisions led to any trade-offs, as they were the most recommended libraries for their particular tasks. I think that
using the CardLayout would have been a nice addition to this project. I would definitely use it to make the layout look cleaner if I had 
more time.
