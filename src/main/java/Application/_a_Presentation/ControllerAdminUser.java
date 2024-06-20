package Application._a_Presentation;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Application.business_logic.BoundaryCommand;
import Application.business_logic.BoundaryUser;
import Application.business_logic.ServicesCommand;
import Application.business_logic.ServicesObject;
import Application.business_logic.ServicesUser;

@RestController
@RequestMapping(path = { "/superapp/admin" })
public class ControllerAdminUser {
	private ServicesUser servicesUser;
	private ServicesObject servicesObject;
	private ServicesCommand ServicesCommand;
	public ControllerAdminUser(ServicesUser servicesUser, ServicesObject servicesObject,
			ServicesCommand servicesCommand) {
		this.servicesUser = servicesUser;
		this.servicesObject = servicesObject;
		ServicesCommand = servicesCommand;
	}
	@DeleteMapping
	(path  = {"/users"})
	public void deleteAllUsers(@RequestParam("email") String email , @RequestParam("userSuperapp") String superapp) {
		String id = email+"_"+superapp;
		this.servicesUser.deleteAllUsers(id);
	}
	@DeleteMapping(path = {"/objects"})
	public void deleteAllObjects(@RequestParam("email") String email , @RequestParam("userSuperapp") String superapp) {
		String id = email+"_"+superapp;
		this.servicesObject.deleteAllObjs(id);
	}
	@DeleteMapping(path = {"/miniapp"})
	public void deleteAllMiniAppsCommands(@RequestParam("email") String email , @RequestParam("userSuperapp") String superapp) {
		String id = email+"_"+superapp;
		this.ServicesCommand.deleteAllminiAppCommandes(id);
	}
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
				path = {"/users"})
	public BoundaryUser[] getAllUsers 
	(@RequestParam("email") String email , @RequestParam("userSuperapp") String superapp,@RequestParam("size") int size,@RequestParam("page")int page) {
		//add  		String id = email+"_"+superapp;
		String id = email+"_"+superapp;
		return this.servicesUser
			.getAllUsers(id, page, size)
			.toArray(new BoundaryUser[0]);
	}
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
				path = {"/miniapp"})
	public BoundaryCommand[] getAllMiniAppsCommands
	(@RequestParam("email") String email , @RequestParam("userSuperapp") String superapp,@RequestParam("size") int size,@RequestParam("page")int page) {
		//add  		String id = email+"_"+superapp;
		String id = email+"_"+superapp;
		return this.ServicesCommand
				.getAllMiniAppsCommands(id, page, size)
				.toArray(new BoundaryCommand[0]);
	}
	@GetMapping(
			path = { "/miniapp/{miniAppName}" }, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public BoundaryCommand[] getSpecificCommandsFromMiniApp
	(@PathVariable("miniAppName") String idMiniAppName, @RequestParam("email") String email , @RequestParam("userSuperapp") String superapp,@RequestParam("size") int size,@RequestParam("page")int page) {
		//add  		String id = email+"_"+superapp;
		String idUser = email+"_"+superapp;
		return this.ServicesCommand
				.getAllCommandsOfSpecificMiniApp(idMiniAppName,idUser, page, size)
				.toArray(new BoundaryCommand[0]);
	}
	
}
