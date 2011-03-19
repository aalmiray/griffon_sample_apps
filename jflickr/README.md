Shootout comparison for the same application written with Griffon,
one using Java/XML, the other just Groovy.

Jflickr (Java)

     +----------------------+-------+-------+
     | Name                 | Files |  LOC  |
     +----------------------+-------+-------+
     | Models               |     1 |    20 | 
     | Views                |     1 |  x129 | 
     | Controllers          |     1 |    20 | 
     | Services             |     1 |    77 | 
     | Lifecycle            |     5 |     5 | 
     | Groovy/Java Sources  |     2 |    36 | 
     +----------------------+-------+-------+
     | Totals               |    11 |   287 | 
     +----------------------+-------+-------+

x includes 21 LOC from JflickrView.xml


Flickr (Groovy)

     +----------------------+-------+-------+
     | Name                 | Files |  LOC  |
     +----------------------+-------+-------+
     | Models               |     1 |     6 | 
     | Views                |     1 |    38 | 
     | Controllers          |     1 |    28 | 
     | Services             |     1 |    23 | 
     | Lifecycle            |     5 |     5 | 
     +----------------------+-------+-------+
     | Totals               |     9 |  x104 | 
     +----------------------+-------+-------+

x includes 4 LOC from Events.groovy

Not only is the Java version close to 3 times larger than the Groovy
version, I also spent almost thrice the time to build it. I had to
battle the type system and compiler, besides processing the XML response
from the flickr APIs. Whereas in the Groovy version I had to battle
the flickr APIs only, but RESTClient and GPath made that job an easier
one.

Bear in mind I built the Groovy version first so I already knew
what the expected results were before undertaking the Java version.
