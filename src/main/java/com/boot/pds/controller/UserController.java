package com.boot.pds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boot.pds.model.ResponseMensajeDto;
import com.boot.pds.model.UserModel;
import com.boot.pds.service.IUserService;
import com.boot.pds.util.Constantes;

@RestController
@RequestMapping(Constantes.USER_CONTROLLER)
public class UserController {

	private final IUserService iUserService;
	
	@Autowired
	public UserController(IUserService iUserService) {
		this.iUserService = iUserService;
	}
	
	
	@GetMapping(value = "")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public List<UserModel> mostrarListaUsuarios(){
		return iUserService.mostrarListaUsuarios();
	}
	
	@PostMapping(value = "", produces = "application/json", consumes = "application/json")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseMensajeDto registrarUsuario(@RequestBody UserModel datosUsuarioNuevo) {
		return iUserService.registrarUsuario(datosUsuarioNuevo);
	}
	
	@DeleteMapping(value = "/{idUser}")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseMensajeDto eliminarUsuario(@PathVariable("idUser") Integer idUser) {
		return iUserService.eliminarUsuario(idUser);
	}
}
