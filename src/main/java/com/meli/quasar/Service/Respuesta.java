package com.meli.quasar.Service;

import java.util.ArrayList;
import java.util.List;

public class Respuesta {

    public static double[] getLocation( double [][] positions, double [] distance){
        
        double[] kenobi = {positions[0][0],positions[0][1]};
        double[] skywalker = {positions[1][0],positions[1][1]};
        double[] sato = {positions[2][0],positions[2][1]};
        double r1=distance[0];
        double r2=distance[1];
        double r3=distance[2];
        double A,B,C,D,E,F,x,y;

        A = 2*skywalker[0] - 2*kenobi[0];
        B = 2*skywalker[1] - 2*kenobi[1];
        C = Math.pow(r1, 2) - Math.pow(r2, 2) - Math.pow(kenobi[0],2) + Math.pow(skywalker[0],2) - Math.pow(kenobi[1],2) + Math.pow(skywalker[1],2);
        D = 2*sato[0] - 2*skywalker[0];
        E = 2*sato[1] - 2*skywalker[1];
        F = Math.pow(r2,2) - Math.pow(r3,2) - Math.pow(skywalker[0],2) + Math.pow(sato[0],2) - Math.pow(skywalker[1],2) + Math.pow(sato[1],2);
        x = (C*E - F*B) / (E*A - B*D);
        y = (C*D - A*F) / (B*D - A*E);
        System.out.println(x);
        System.out.println(y);
        double[] location={x,y};
        return location;
    }

    public static String getMessage( List<List<String>> messages){

        List<String> message1=messages.get(0);
        List<String> message2=messages.get(1);
        List<String> message3=messages.get(2);

        List<String> list = new ArrayList<String>();
        String messagecomplete="";

        for (int x=0;x<message1.size();x++) {
            if(message1.get(x) != "") {list.add(message1.get(x));}
            else if (message2.get(x) != "") {list.add(message2.get(x));}
            else if (message3.get(x) != "") {list.add(message3.get(x));}
            else {list.add(message3.get(x));}
        }
        for (String mess : list) {
			messagecomplete+= mess+" ";
		}
        return messagecomplete;
        //location.setMessage(messagecomplete);
        //System.out.println(list.toString());

    }

        
}
