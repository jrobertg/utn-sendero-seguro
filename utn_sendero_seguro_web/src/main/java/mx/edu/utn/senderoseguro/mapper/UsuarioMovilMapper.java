package mx.edu.utn.senderoseguro.mapper;

import static mx.edu.utn.senderoseguro.mapper.UsuarioMovilDynamicSqlSupport.apellidos;
import static mx.edu.utn.senderoseguro.mapper.UsuarioMovilDynamicSqlSupport.contrasena;
import static mx.edu.utn.senderoseguro.mapper.UsuarioMovilDynamicSqlSupport.correo;
import static mx.edu.utn.senderoseguro.mapper.UsuarioMovilDynamicSqlSupport.fechaCreacionBd;
import static mx.edu.utn.senderoseguro.mapper.UsuarioMovilDynamicSqlSupport.fechaUltimoMovimiento;
import static mx.edu.utn.senderoseguro.mapper.UsuarioMovilDynamicSqlSupport.idEstatus;
import static mx.edu.utn.senderoseguro.mapper.UsuarioMovilDynamicSqlSupport.idTipoUsuario;
import static mx.edu.utn.senderoseguro.mapper.UsuarioMovilDynamicSqlSupport.idUsuarioMovil;
import static mx.edu.utn.senderoseguro.mapper.UsuarioMovilDynamicSqlSupport.nombres;
import static mx.edu.utn.senderoseguro.mapper.UsuarioMovilDynamicSqlSupport.usuarioMovil;
import static org.apache.ibatis.type.JdbcType.INTEGER;
import static org.apache.ibatis.type.JdbcType.VARCHAR;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.Generated;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import mx.edu.utn.senderoseguro.entidad.UsuarioMovil;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.ModeloUsuarioMovil;
import mx.edu.utn.senderoseguro.web.datatables.BaseFilter;

@Mapper
public interface UsuarioMovilMapper
		extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<UsuarioMovil>, CommonUpdateMapper {

	// @formatter:off
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.772358-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    BasicColumn[] selectList = BasicColumn.columnList(idUsuarioMovil, correo, contrasena, nombres, apellidos, idTipoUsuario, idEstatus, fechaCreacionBd, fechaUltimoMovimiento);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.770289-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UsuarioMovilResult", value = {
        @Result(column="id_usuario_movil", property="idUsuarioMovil", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="correo", property="correo", jdbcType=JdbcType.VARCHAR),
        @Result(column="contrasena", property="contrasena", jdbcType=JdbcType.VARCHAR),
        @Result(column="nombres", property="nombres", jdbcType=JdbcType.VARCHAR),
        @Result(column="apellidos", property="apellidos", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_tipo_usuario", property="idTipoUsuario", jdbcType=JdbcType.INTEGER),
        @Result(column="id_estatus", property="idEstatus", jdbcType=JdbcType.INTEGER),
        @Result(column="fecha_creacion_bd", property="fechaCreacionBd", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="fecha_ultimo_movimiento", property="fechaUltimoMovimiento", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UsuarioMovil> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.771015-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UsuarioMovilResult")
    Optional<UsuarioMovil> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.771155-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, usuarioMovil, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.771545-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, usuarioMovil, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.77166-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    default int deleteByPrimaryKey(Integer idUsuarioMovil_) {
        return delete(c -> 
            c.where(idUsuarioMovil, isEqualTo(idUsuarioMovil_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.771698-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    default int insert(UsuarioMovil row) {
        return MyBatis3Utils.insert(this::insert, row, usuarioMovil, c ->
            c.map(idUsuarioMovil).toProperty("idUsuarioMovil")
            .map(correo).toProperty("correo")
            .map(contrasena).toProperty("contrasena")
            .map(nombres).toProperty("nombres")
            .map(apellidos).toProperty("apellidos")
            .map(idTipoUsuario).toProperty("idTipoUsuario")
            .map(idEstatus).toProperty("idEstatus")
            .map(fechaCreacionBd).toProperty("fechaCreacionBd")
            .map(fechaUltimoMovimiento).toProperty("fechaUltimoMovimiento")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.771811-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    default int insertMultiple(Collection<UsuarioMovil> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, usuarioMovil, c ->
            c.map(idUsuarioMovil).toProperty("idUsuarioMovil")
            .map(correo).toProperty("correo")
            .map(contrasena).toProperty("contrasena")
            .map(nombres).toProperty("nombres")
            .map(apellidos).toProperty("apellidos")
            .map(idTipoUsuario).toProperty("idTipoUsuario")
            .map(idEstatus).toProperty("idEstatus")
            .map(fechaCreacionBd).toProperty("fechaCreacionBd")
            .map(fechaUltimoMovimiento).toProperty("fechaUltimoMovimiento")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.772009-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    default int insertSelective(UsuarioMovil row) {
        return MyBatis3Utils.insert(this::insert, row, usuarioMovil, c ->
            c.map(idUsuarioMovil).toPropertyWhenPresent("idUsuarioMovil", row::getIdUsuarioMovil)
            .map(correo).toPropertyWhenPresent("correo", row::getCorreo)
            .map(contrasena).toPropertyWhenPresent("contrasena", row::getContrasena)
            .map(nombres).toPropertyWhenPresent("nombres", row::getNombres)
            .map(apellidos).toPropertyWhenPresent("apellidos", row::getApellidos)
            .map(idTipoUsuario).toPropertyWhenPresent("idTipoUsuario", row::getIdTipoUsuario)
            .map(idEstatus).toPropertyWhenPresent("idEstatus", row::getIdEstatus)
            .map(fechaCreacionBd).toPropertyWhenPresent("fechaCreacionBd", row::getFechaCreacionBd)
            .map(fechaUltimoMovimiento).toPropertyWhenPresent("fechaUltimoMovimiento", row::getFechaUltimoMovimiento)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.772471-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    default Optional<UsuarioMovil> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, usuarioMovil, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.772522-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    default List<UsuarioMovil> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, usuarioMovil, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.772569-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    default List<UsuarioMovil> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, usuarioMovil, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.772612-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    default Optional<UsuarioMovil> selectByPrimaryKey(Integer idUsuarioMovil_) {
        return selectOne(c ->
            c.where(idUsuarioMovil, isEqualTo(idUsuarioMovil_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.772665-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, usuarioMovil, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.772713-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    static UpdateDSL<UpdateModel> updateAllColumns(UsuarioMovil row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(idUsuarioMovil).equalTo(row::getIdUsuarioMovil)
                .set(correo).equalTo(row::getCorreo)
                .set(contrasena).equalTo(row::getContrasena)
                .set(nombres).equalTo(row::getNombres)
                .set(apellidos).equalTo(row::getApellidos)
                .set(idTipoUsuario).equalTo(row::getIdTipoUsuario)
                .set(idEstatus).equalTo(row::getIdEstatus)
                .set(fechaCreacionBd).equalTo(row::getFechaCreacionBd)
                .set(fechaUltimoMovimiento).equalTo(row::getFechaUltimoMovimiento);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.772804-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UsuarioMovil row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(idUsuarioMovil).equalToWhenPresent(row::getIdUsuarioMovil)
                .set(correo).equalToWhenPresent(row::getCorreo)
                .set(contrasena).equalToWhenPresent(row::getContrasena)
                .set(nombres).equalToWhenPresent(row::getNombres)
                .set(apellidos).equalToWhenPresent(row::getApellidos)
                .set(idTipoUsuario).equalToWhenPresent(row::getIdTipoUsuario)
                .set(idEstatus).equalToWhenPresent(row::getIdEstatus)
                .set(fechaCreacionBd).equalToWhenPresent(row::getFechaCreacionBd)
                .set(fechaUltimoMovimiento).equalToWhenPresent(row::getFechaUltimoMovimiento);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.773009-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    default int updateByPrimaryKey(UsuarioMovil row) {
        return update(c ->
            c.set(correo).equalTo(row::getCorreo)
            .set(contrasena).equalTo(row::getContrasena)
            .set(nombres).equalTo(row::getNombres)
            .set(apellidos).equalTo(row::getApellidos)
            .set(idTipoUsuario).equalTo(row::getIdTipoUsuario)
            .set(idEstatus).equalTo(row::getIdEstatus)
            .set(fechaCreacionBd).equalTo(row::getFechaCreacionBd)
            .set(fechaUltimoMovimiento).equalTo(row::getFechaUltimoMovimiento)
            .where(idUsuarioMovil, isEqualTo(row::getIdUsuarioMovil))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.773107-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    default int updateByPrimaryKeySelective(UsuarioMovil row) {
        return update(c ->
            c.set(correo).equalToWhenPresent(row::getCorreo)
            .set(contrasena).equalToWhenPresent(row::getContrasena)
            .set(nombres).equalToWhenPresent(row::getNombres)
            .set(apellidos).equalToWhenPresent(row::getApellidos)
            .set(idTipoUsuario).equalToWhenPresent(row::getIdTipoUsuario)
            .set(idEstatus).equalToWhenPresent(row::getIdEstatus)
            .set(fechaCreacionBd).equalToWhenPresent(row::getFechaCreacionBd)
            .set(fechaUltimoMovimiento).equalToWhenPresent(row::getFechaUltimoMovimiento)
            .where(idUsuarioMovil, isEqualTo(row::getIdUsuarioMovil))
        );
    }
    
    @SelectProvider(type = UsuarioMovilDynamicSqlSupport.class, method = "obtenerModeloUsuariosMovil")
	@Results({
		@Result(column = "id_usuario_movil", property = "idUsuarioMovil", jdbcType = INTEGER, id = true),
		@Result(column = "correo", property = "correo", jdbcType = VARCHAR),
		@Result(column = "nombres", property = "nombres", jdbcType = VARCHAR),
		@Result(column = "apellidos", property = "apellidos", jdbcType = VARCHAR),
		@Result(column = "id_tipo_usuario", property = "idTipoUsuario", jdbcType = INTEGER),
		@Result(column = "tipo_usuario", property = "tipoUsuario", jdbcType = VARCHAR),
		@Result(column = "id_estatus", property = "idEstatus", jdbcType = INTEGER),
		@Result(column = "estatus_usuario", property = "estatusUsuario", jdbcType = VARCHAR),
		@Result(column = "rnum", property = "rnum", jdbcType = INTEGER),
		@Result(column = "totalRecords", property = "totalRecords", jdbcType = INTEGER)
	})
	List<ModeloUsuarioMovil> obtenerModeloUsuariosMovil(BaseFilter filtros);
    
    default Optional<UsuarioMovil> obtenerPorCorreo(String correo_) {
    	return selectOne(c ->
    		c.where(correo, isEqualTo(correo_))
    	);
    }
    // @formatter:on
}