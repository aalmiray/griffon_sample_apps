package login

import groovy.beans.Bindable
import griffon.transform.PropertyListener

@PropertyListener(enabler)
class LoginModel {
    @Bindable String username
    @Bindable String password
    @Bindable boolean enabled

    private enabler = { evt ->
        if(evt.propertyName == 'enabled') return
        enabled = username && password
    }
}
