package com.anadunning.phoebus_tech_test.models.dto;

public class ResourceAverageDTO {
	
	    private String description;
	    private double averagePerCentre;
	    
		public ResourceAverageDTO() {
		}

		public ResourceAverageDTO(String description, double averagePerCentre) {
			this.description = description;
			this.averagePerCentre = averagePerCentre;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getAveragePerCentre() {
			return averagePerCentre;
		}

		public void setAveragePerCentre(double averagePerCentre) {
			this.averagePerCentre = averagePerCentre;
		}
		
		@Override
	    public String toString() {
	        return "ResourceAverageDTO{" +
	                "description='" + description + '\'' +
	                ", averagePerCentre=" + averagePerCentre +
	                '}';
	    }
}