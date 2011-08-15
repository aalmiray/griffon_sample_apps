import groovy.beans.Bindable
import java.beans.PropertyChangeListener
import com.ericsson.otp.erlang.*

class ErlangTestModel {
   @Bindable String server
   @Bindable String num1
   @Bindable String num2
   @Bindable String result
   @Bindable boolean enabled
   @Bindable boolean serverEnabled = true
   OtpConnection connection

   ErlangTestModel() {
      addPropertyChangeListener({ e ->
          if(e.propertyName == 'enabled' || e.propertyName == 'serverEnabled') return
          if(num1 && num2 && server) { 
              if(serverEnabled) {
                  OtpSelf client = new OtpSelf('clientnode', 'cookie')
                  connection = client.connect(new OtpPeer(server))
                  serverEnabled = false
              }
              enabled = true
          }
      } as PropertyChangeListener)
   }
}
