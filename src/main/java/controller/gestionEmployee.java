package controller;
import javax.ws.rs.core.Response ; 
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;

import entity.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Path("employees")
@Api
public class gestionEmployee  {
	
	public static  List<Employee> e=new ArrayList<Employee>();
	
	public gestionEmployee()  {
	Employee E1 = new Employee(12,"foulen","ben foulen") ;  
	Employee E2 = new Employee(12,"ahmed","gouiaa");
	e.add(E1);
	e.add(E2);
 
 	
}
	public int getIndexByCin(int cin) {
		for(Employee emp: e) {
			if (emp.getCin()==cin)
				return e.indexOf(emp);
		}
		return -1;
	}

	@Path("/getAllEmployees")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@ApiOperation(value = "GET all Employes")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public Response displayEmployeesList() {
		GenericEntity<List<Employee>> entity = new GenericEntity<List<Employee>>(e) {}; 

		if(e.size()!=0)
			return Response.status(Status.OK).entity(entity).build();
		else
			return Response.status(Status.NOT_FOUND).build();
	}
	
	
 
	@Path("/add")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value = "Post an epmploye")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public String ajouterEmploye(Employee employe) {
		 if(e.add(employe))
	 return "Add Successful";
		return "Echec";
	}
	
	
	@Path("/updateEmployee/{id}")
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value = "update an epmploye")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public String updateEmployee(Employee emp , @PathParam("id") int id) {
		int index = this.getIndexByCin(id);
		if( index!=-1) {
			Employee oldemp =  e.get(index) ;
			oldemp.setCin(emp.getCin());
			oldemp.setNom(emp.getNom());
			oldemp.setPrenom(emp.getPrenom());
			return "updated"   ; 
		}
		else {
			return "employee not found" ; 
		}

	}

	
	
	@Path("/deleteEmployee/{id}")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value = "delete an epmploye")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public String deleteEmployee(Employee emp , @PathParam("id") int id) {
		
		int index = this.getIndexByCin(id);
		if( index!=-1) {
			e.remove(index);
			return "deleted"   ; 
		}
		else {
			return "employee not found" ; 
		}

 

	}

	
	@Path("/searchEmployee/{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@ApiOperation(value = "search an epmploye")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public Response searchEmployee( @PathParam("id") int id) {
		int index = this.getIndexByCin(id);
		if( index!=-1) {
			Employee emp =  e.get(index);
			return Response.status(Status.OK).entity(emp).build();   
		}
		else {
			return Response.status(Status.OK).entity("no").build(); 
		}

	}



  

}
