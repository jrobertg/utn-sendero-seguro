package mx.edu.utn.senderoseguro.mapper;

import static org.apache.ibatis.type.JdbcType.INTEGER;
import static org.apache.ibatis.type.JdbcType.VARCHAR;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import mx.edu.utn.senderoseguro.mapper.provider.UserSqlProvider;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.ModeloUsuario;
import mx.edu.utn.senderoseguro.web.datatables.BaseFilter;

@Mapper
public interface UserMapper {
	
	@SelectProvider(type = UserSqlProvider.class, method = "obtenerConsultaModeloUsuarios")
	@Results({
		@Result(column = "id", property = "id", jdbcType = INTEGER, id = true),
		@Result(column = "email", property = "email", jdbcType = VARCHAR),
		@Result(column = "first_name", property = "firstName", jdbcType = VARCHAR),
		@Result(column = "last_name", property = "lastName", jdbcType = VARCHAR),
		@Result(column = "id_status", property = "idStatus", jdbcType = INTEGER),
		@Result(column = "rnum", property = "rnum", jdbcType = INTEGER),
		@Result(column = "totalRecords", property = "totalRecords", jdbcType = INTEGER),
	})
	List<ModeloUsuario> obtenerConsultaModeloUsuarios(BaseFilter filtros);
	
	@UpdateProvider(type = UserSqlProvider.class, method = "activarUsuarios")
	int activarUsuarios(@Param("idUsuarios") List<Integer> idUsuarios);
	
	@UpdateProvider(type = UserSqlProvider.class, method = "inactivarUsuarios")
	int inactivarUsuarios(@Param("idUsuarios") List<Integer> idUsuarios);

}
