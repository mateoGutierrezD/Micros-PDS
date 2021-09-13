package com.boot.pds.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.pds.dao.IUserDao;
import com.boot.pds.entities.User;
import com.boot.pds.mapper.IMapperUser;
import com.boot.pds.model.ResponseMensajeDto;
import com.boot.pds.model.UserModel;
import com.boot.pds.service.IUserService;
import com.boot.pds.util.Constants;

@Service
public class UserService implements IUserService{

	private final IUserDao iUserDao;
	private final IMapperUser iMapperUser;
	
	@Autowired
	public UserService (IUserDao iUserDao, IMapperUser iMapperUser) {
		this.iUserDao = iUserDao;
		this.iMapperUser = iMapperUser;
	}
	
	@Override
	public List<UserModel> mostrarListaUsuarios() {
		List<UserModel> usuarios = new LinkedList<>();
		List<User> useriosEntities = iUserDao.findAll();
		for(User usuario : useriosEntities) {
			usuarios.add(iMapperUser.mappearUsuario(usuario));
		}
		return usuarios;
	}

	@Override
	public ResponseMensajeDto registrarUsuario(UserModel datosUsuarioNuevo) {
		User registroUsuario = new User();
		ResponseMensajeDto respuestaMensaje = new ResponseMensajeDto();
		
		registroUsuario.setName(datosUsuarioNuevo.getName());
		registroUsuario.setLastname(datosUsuarioNuevo.getLastname());
		iUserDao.save(registroUsuario);
		respuestaMensaje.setMensajeRespuesta(Constants.MENSAJE_REGISTRO);
		return respuestaMensaje;
	}

	@Override
	public ResponseMensajeDto eliminarUsuario(Integer idUser) {
		ResponseMensajeDto respuestaMensaje = new ResponseMensajeDto();
		Optional<User> userData = iUserDao.findById(idUser);
		if(!userData.isPresent()) {
			throw new NoSuchElementException(Constants.MENSAJE_REGISTRO_INEXISTENTE);
		}else {
			iUserDao.deleteById(idUser);
			respuestaMensaje.setMensajeRespuesta(Constants.MENSAJE_ELIMINACION_EXITOSA);
			return respuestaMensaje;
		}
		
	}

}
