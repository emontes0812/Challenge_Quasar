package com.meli.quasar;
 
import java.util.ArrayList;
import java.util.List;

import com.meli.quasar.Position.Position;
import com.meli.quasar.Position.PositionWrapper;
import com.meli.quasar.Satellite.Satellite;
import com.meli.quasar.Satellite.SatelliteWrapper;
import com.meli.quasar.SatelliteSplit.SatelliteSplit;
import com.meli.quasar.Service.Respuesta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
 
@RestController
public class SatelliteController {
 
    PositionSatellites kenobi = new PositionSatellites("kenobi",-500,-200,100);
    PositionSatellites skywalker = new PositionSatellites("skywalker",100,-100,100);
    PositionSatellites sato = new PositionSatellites("sato",500,100,100);
    PositionWrapper res = new PositionWrapper();
    PositionWrapper res_split = new PositionWrapper();
    SatelliteWrapper satelliteSplitWrapper= new SatelliteWrapper();
    double [][] positions = new double [3][2];
    double [] location = new double[2];
    String message="";

    static List<Satellite> listsplit=new ArrayList<Satellite>();
    static {
         
        listsplit.add(new Satellite("",0.0, List.of("","")));
        listsplit.add(new Satellite("",0.0, List.of("","")));
        listsplit.add(new Satellite("",0.0, List.of("","")));
         
    }

    static List<PositionSatellites> lista=new ArrayList<PositionSatellites>();
    static {
         
        lista.add(new PositionSatellites("kenobi",-500,-200,100));
        lista.add(new PositionSatellites("skywalker",100,-100,100));
        lista.add(new PositionSatellites("sato",500,100,100));
         
    }
    
    /**
     * Determina la posicion de la nave de acuerdo a los puntos dados.
     * @param sat lista de mensajes recibidos por los satelites y la distancia de cada uno a la nave. 
     * @return devuelve la ubicacion (x,y) y el mensaje de la nave
     */
    @PostMapping("/topsecret/")
    ResponseEntity<PositionWrapper> insertarPosicion( @RequestBody SatelliteWrapper  sat) {
        //satelliteSplitWrapper.setSatellites(sat.getSatellites());
        for (int j=0; j<lista.size(); j++) {
            positions[j][0]=lista.get(j).getposx();
            positions[j][1]=lista.get(j).getposy();
        }
        if(sat.getSatellites().size() < 3){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        location=Respuesta.getLocation(positions,sat.getDistances());
        message=Respuesta.getMessage(sat.getMessages());
        res.setPosition(new Position(location[0],location[1]));
        res.setMessage(message);
        return new ResponseEntity<>(res, HttpStatus.OK) ;    
    }

    /**
     * Recibe los mensajes de cada uno de los satelites
     * @param satsplit lista de mensaje recibidos por el satelite {satellite_name}
     * @return devuelve la ubicacion (x,y) y el mensaje de la nave
     */
    @PostMapping("/topsecret_split/{satellite_name}")
    public void insertarPosicion(@PathVariable String satellite_name, @RequestBody SatelliteSplit  satsplit) {   
        if(satellite_name.equals("kenobi")){
            listsplit.set(0,new Satellite(satellite_name,satsplit.getDistance(),satsplit.getMessage()));
        }
        if(satellite_name.equals("skywalker")){
            listsplit.set(1,new Satellite(satellite_name,satsplit.getDistance(),satsplit.getMessage()));
        }
        if(satellite_name.equals("sato")){
            listsplit.set(2,new Satellite(satellite_name,satsplit.getDistance(),satsplit.getMessage()));
        }
        satelliteSplitWrapper.setSatellites(listsplit);
    }

    /**
     * Determina la posicion de la nave de acuerdo a los puntos dados individualmente.
     * @return devuelve la ubicacion (x,y) y el mensaje de la nave
     */
    @GetMapping("/topsecret_split/")
    ResponseEntity<PositionWrapper> getPositionSpli() {
        for (int j=0; j<lista.size(); j++) {
            positions[j][0]=lista.get(j).getposx();
            positions[j][1]=lista.get(j).getposy();
        }
        for(int i=0;i<3;i++){
            if (satelliteSplitWrapper.getSatellites().get(i).getName().equals("")){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }
        location=Respuesta.getLocation(positions,satelliteSplitWrapper.getDistances());
        message=Respuesta.getMessage(satelliteSplitWrapper.getMessages());
        res_split.setPosition(new Position(location[0],location[1]));
        res_split.setMessage(message);
        return new ResponseEntity<>(res_split,HttpStatus.OK);
    }
}