package babel.math

import com.ericsson.otp.erlang.*

class ErlangCalculator implements Calculator {
    private OtpConnection conn

    double add(double a, double b) {
        connect()
        conn.sendRPC('mathserver', 'add', [a, b].toErlang())
        conn.receiveRPC().doubleValue()
    }

    private connect() {
        if(conn) return
        OtpSelf cNode = new OtpSelf("clientnode", "cookie")
        OtpPeer sNode = new OtpPeer("servernode@aalmiray.canoo.com") 
        conn = cNode.connect(sNode)
    }
}
