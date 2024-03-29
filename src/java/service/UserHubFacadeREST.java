/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package service;

import com.stip.find.entity.UserHub;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;

/**
 *
 * @author BlueBerry
 */
@Stateless
@Path("com.stip.find.entity.userhub")
public class UserHubFacadeREST extends AbstractFacade<UserHub> {
    @PersistenceContext(unitName = "FindPU")
    private EntityManager em;

    public UserHubFacadeREST() {
        super(UserHub.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(UserHub entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(UserHub entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public UserHub find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<UserHub> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<UserHub> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @java.lang.Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
