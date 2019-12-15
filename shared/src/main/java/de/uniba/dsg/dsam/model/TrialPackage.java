package de.uniba.dsg.dsam.model;

import java.io.Serializable;

public class TrialPackage extends Incentive implements Serializable {
    final String TrialPackage ="trialpackage";

    public TrialPackage(String name) {
        super(name);
    }

    public String getTrialPackage() {
        return TrialPackage;
    }

}
