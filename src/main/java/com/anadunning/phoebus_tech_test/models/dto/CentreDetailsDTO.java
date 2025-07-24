package com.anadunning.phoebus_tech_test.models.dto;

import java.util.List;

import com.anadunning.phoebus_tech_test.models.entities.CommunityCentre;
import com.anadunning.phoebus_tech_test.models.entities.Exchange;
import com.anadunning.phoebus_tech_test.models.entities.Resource;

public class CentreDetailsDTO {
	
	private CommunityCentre centre;
    private List<Resource> resources;
    private List<Exchange> exchanges;
    
	public CentreDetailsDTO() {
	}
	
	public CentreDetailsDTO(CommunityCentre centre, List<Resource> resources, List<Exchange> exchanges) {
		this.centre = centre;
		this.resources = resources;
		this.exchanges = exchanges;
	}

	public CommunityCentre getCentre() {
		return centre;
	}

	public void setCentre(CommunityCentre centre) {
		this.centre = centre;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public List<Exchange> getExchanges() {
		return exchanges;
	}

	public void setExchanges(List<Exchange> exchanges) {
		this.exchanges = exchanges;
	}

}
