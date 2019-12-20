 package de.uniba.dsg.dsam.persistence;

 import de.uniba.dsg.dsam.model.Incentive;

 import java.util.List;

 public interface IncentiveManagement {

     public void create(Incentive incentive);
     public Incentive getIncentives(int incentiveID);
     public void update(int incentiveID, String incentiveType);
     public List<Incentive> getAllIncentive() ;
     public void delete(int id);
 }