package org.openstack.ceilometer.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.CeilometerCommand;
import org.openstack.ceilometer.model.ResourceAggregations;

public class VolumeSumOfProjectRawEvents implements CeilometerCommand<ResourceAggregations> {

	private String source;
	
	private String project;
	
	private String meter;
	
	public VolumeSumOfProjectRawEvents(String source, String project, String meter) {
		this.source = source;
		this.project = project;
		this.meter = meter;
	}

	@Override
	public ResourceAggregations execute(WebTarget target) {
		return target.path("source").path("projects").path(project).path(meter).path("volume").request(MediaType.APPLICATION_JSON).get(ResourceAggregations.class);
	}

}