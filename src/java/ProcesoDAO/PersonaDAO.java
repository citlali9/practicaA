/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProcesoDAO;

import HBM.Util;
import Pojo.Persona;
import Pojo.TipoPersona;
import java.util.List;

import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author citlalli
 */
public class PersonaDAO {
    Session session;
    
    public PersonaDAO(){
       session=Util.getLocalSession();
    }
    
    public Persona getPersonaById(int id){
        return (Persona) session.load(Persona.class, id);
    }
    public List<Persona> getPersonaByidtipo(String tetiqueta){
        List<Persona> listaDePersonas=(List<Persona>)
                session.createCriteria(Persona.class)
                .add(Restrictions.eq("idtabla", tetiqueta));
        return listaDePersonas;
    }
    public boolean updateById(int id,Persona persona){
        Persona personaAModificar=getPersonaById(id);
        try{
            Transaction transaccion=session.beginTransaction();
            personaAModificar.setNombre(persona.getNombre());
            session.update(personaAModificar);
            transaccion.commit();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean savePersona(String nombre,String materno,String paterno,String telefono,int idTipoPersona){
        Persona personaRegistro=new Persona();
        TipoPersona tipoDeDato=(TipoPersona)session.load(TipoPersona.class, idTipoPersona);
        personaRegistro.setNombre(nombre);
        personaRegistro.setMaterno(materno);
        personaRegistro.setPaterno(paterno);
        personaRegistro.setTelefono(telefono);
        personaRegistro.setTipoPersona(tipoDeDato);
        try{
            Transaction transaccion=session.beginTransaction();
            session.save(personaRegistro);
            transaccion.commit();
            return true;
        }catch(Exception e){
            
        }finally{
            
        }
        return true;
    }   
}
