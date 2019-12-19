 package de.uniba.dsg.dsam.persistence;

 import de.uniba.dsg.dsam.model.Incentive;

 import java.util.List;

 public interface IncentiveManagement {

     public void create(Incentive incentive);
     public void create(Incentive incentive,Boolean isTrial);

     //Incentives CRUD operations
     public void create(String incentiveType, String name);
     public List<Incentive> getPromotionalIncentives();
     public List<Incentive> getTrialIncentives();
     public Incentive getIncentives(int incentiveID);
     public void update(int incentiveID, String incentiveType);
     public void delete(int incentiveID) ;
     public List<Incentive> combineIncentives() ;

 }