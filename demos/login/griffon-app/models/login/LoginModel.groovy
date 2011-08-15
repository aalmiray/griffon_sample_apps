package login

import groovy.beans.Bindable
import griffon.beans.Listener

@Listener(enabler)
class LoginModel {
    @Bindable String username
    @Bindable String password
    @Bindable boolean enabled

    private enabler = { evt ->
        if(evt.propertyName == 'enabled') return
        enabled = username && password
    }
}
