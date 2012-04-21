/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.stip.find.da;

import com.stip.find.entity.UserHub;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author BlueBerry
 */
@Stateless
@LocalBean
public class FindDao {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    EntityManager em;
    public UserHub findHusterByUID(String uid){
    return  em.find(UserHub.class, uid);
    }
    public List<UserHub> findHusterByName(String name){
    Query thisQuery=em.createNamedQuery("UserHub.findByName");
    thisQuery.setParameter("name", name);
    List<UserHub> userHubs=thisQuery.getResultList();
    return  userHubs;
    
    }
    public List<UserHub> findHusterByName2(String name){
    Query thisQuery=em.createNamedQuery("UserHub.findByName");
    thisQuery.setParameter("name", name);
    List list=thisQuery.getResultList();
    List<UserHub> userHubs=new ArrayList<UserHub>();
        for (Iterator it = list.iterator(); it.hasNext();) {
            UserHub userHub = (UserHub)it.next();
            userHubs.add(userHub);
            
        }
    return  userHubs;
    }
}
