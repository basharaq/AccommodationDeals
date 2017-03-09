#About This App

This app is a simple website that when started statically calls a REST API,
passes the resulting JSON string into a repository object that parses it and
stores relevant data into a collection of simple domain models.

#The Repository

The repository is represented by the ```HotelDealsRepository``` class. This
class has only one method which simply accepts a JSON string, parses it and
stores the relevant data into the domain models.

One possible limitation of this repository is proper validation of the object
that results from the JSON parsing. Currently it uses a primitive validation
mechanism which simply looks for null objects and returning null.
 
#The Collection

Represented by the ```HotelDealsCollection```, it simply encapsulates a list of
deals (i.e. a search result), and some other information that pertains to the whole
list such as language, currency, and travel dates.

This implementation is quite simple. A more elegant solution would be to have this
class implement ```java.util.List``` so that the class itself can be accesses like
a collection instead of having to call getter to get the list. I thought that such
an implementation would be an overkill for this simply use case :)

#The Deal And The Hotel

Represented by the ```HotelDeal``` and ```Hotel``` classes respectively. Those classes
simply encapsulate simply data about hotels and deals. The relationship I chose is that
the deal contains the information of the hotel. I chose this arrangement for two reasons:

1. The structure of the API's response actually gave me some bias towards it.
Not sure if it is a good-enough reason but it gave the impression that this how
"business" looked at it.

2. The API's response seems to indicate that each hotel has only one deal. If that's
the case then the question of who contains what wouldn't make much difference in this
particular use case.

However, in a more realistic senario, where each hotel would probably have more than
one deal, the arrangement should be changed. The hotel would now include a list of deals
that are associated with it. And the collection would be a hotel collection rather than
a deal collection

#Notes

1. I could see that the API's response is pretty big, and contains lots of information.
To keep things simple, I only extracted a fraction of this information into the domain
models for purposes of viewing.

2. Since there were no requirements on the framework to use, I chose to implement this app
using good-old-servlets. I didn't think that the size of the app warrants using a framework
like Spring. In real-life projects, however, I would always prefer to use a framework that
is suitable to the size of the project rather than writing from scratch.

