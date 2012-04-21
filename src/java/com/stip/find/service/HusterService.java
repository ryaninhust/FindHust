/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.stip.find.service;

import com.stip.find.da.FindDao;
import com.stip.find.entity.UserHub;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author BlueBerry
 */
@Stateless
@LocalBean
@Path("home")
public class HusterService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
   @EJB
   FindDao findDao;
   
   
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   @Path("/husters")
   public  List<UserHub> findHusters(@QueryParam("name")String name){
       if (name!=null) {
          List<UserHub> userHubs=findDao.findHusterByName2(name);
           if (!userHubs.isEmpty()) {
               System.out.println(name);
               return  userHubs;
               
           }
           else{
           throw new WebApplicationException(404);
           }
          
       }
         throw  new WebApplicationException(404);
   
   }
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   @Path("/huster/{uid}")
   public List<UserHub> findHuster(@PathParam("uid") String uid){
       List<UserHub> userHubs=new ArrayList<UserHub>();
       if (uid!=null) {
           UserHub userHub=findDao.findHusterByUID(uid);
           if (userHub!=null) {
               userHubs.add(userHub);
               System.out.println(uid);
               return  userHubs;
           }
           throw  new WebApplicationException(404);
       }
   throw new WebApplicationException(404);
   }

}
