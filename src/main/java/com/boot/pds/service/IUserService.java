package com.boot.pds.service;

import java.util.List;

import com.boot.pds.model.ResponseMensajeDto;
import com.boot.pds.model.UserModel;

public interface IUserService {

	List<UserModel> mostrarListaUsuarios();

	ResponseMensajeDto registrarUsuario(UserModel datosUsuarioNuevo);

	ResponseMensajeDto eliminarUsuario(Integer idUser);

}
