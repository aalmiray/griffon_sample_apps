Simple Wizard
=============

This application demonstrates how a trivial wizard-like bahavior can be created.
All pages are instantiated upon launching the wizard, in other words there is no
lazy page instantiation nor support for adding new pages dynamically. Branching
is not supported either. Furthermore, page models do not have any specific
validation logic in order to keep them simple.

The Back button is tied to the ESCAPE key. Any time a user presses that key the
previous page will be displayed. Likewise, the Next button is tied to both the
ENTER and SPACE key. Be aware that these keys are used to accept text updates
on text components, also triggering state changes in radio and checkboxes. It's
very likely that attempting to change a radio button's state will trigger the
next button instead.

Both controller actions (back and next) skip injection of threading code because
they are only concerned to changing the state of the wizard (which must be done
inside the EDT). If validation were to be added to page updates then these
actions would require proper threading management.
