package mx.edu.utn.senderoseguro.mapper;

import static mx.edu.utn.senderoseguro.mapper.UsuarioWebDynamicSqlSupport.apellidos;
import static mx.edu.utn.senderoseguro.mapper.UsuarioWebDynamicSqlSupport.contrasena;
import static mx.edu.utn.senderoseguro.mapper.UsuarioWebDynamicSqlSupport.correo;
import static mx.edu.utn.senderoseguro.mapper.UsuarioWebDynamicSqlSupport.fechaCreacionBd;
import static mx.edu.utn.senderoseguro.mapper.UsuarioWebDynamicSqlSupport.fechaUltimoMovimiento;
import static mx.edu.utn.senderoseguro.mapper.UsuarioWebDynamicSqlSupport.idEstatus;
import static mx.edu.utn.senderoseguro.mapper.UsuarioWebDynamicSqlSupport.idRolWeb;
import static mx.edu.utn.senderoseguro.mapper.UsuarioWebDynamicSqlSupport.idUsuarioWeb;
import static mx.edu.utn.senderoseguro.mapper.UsuarioWebDynamicSqlSupport.nombres;
import static mx.edu.utn.senderoseguro.mapper.UsuarioWebDynamicSqlSupport.usuarioWeb;
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

import mx.edu.utn.senderoseguro.entidad.UsuarioWeb;
import mx.edu.utn.senderoseguro.web.controlador.dto.usuario.ModeloUsuarioWeb;
import mx.edu.utn.senderoseguro.web.datatables.BaseFilter;

@Mapper
public interface UsuarioWebMapper
		extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<UsuarioWeb>, CommonUpdateMapper {

	// @formatter:off
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.778339-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    BasicColumn[] selectList = BasicColumn.columnList(idUsuarioWeb, correo, contrasena, nombres, apellidos, idRolWeb, idEstatus, fechaCreacionBd, fechaUltimoMovimiento);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.777227-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UsuarioWebResult", value = {
        @Result(column="id_usuario_web", property="idUsuarioWeb", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="correo", property="correo", jdbcType=JdbcType.VARCHAR),
        @Result(column="contrasena", property="contrasena", jdbcType=JdbcType.VARCHAR),
        @Result(column="nombres", property="nombres", jdbcType=JdbcType.VARCHAR),
        @Result(column="apellidos", property="apellidos", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_rol_web", property="idRolWeb", jdbcType=JdbcType.INTEGER),
        @Result(column="id_estatus", property="idEstatus", jdbcType=JdbcType.INTEGER),
        @Result(column="fecha_creacion_bd", property="fechaCreacionBd", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="fecha_ultimo_movimiento", property="fechaUltimoMovimiento", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UsuarioWeb> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.777648-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UsuarioWebResult")
    Optional<UsuarioWeb> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.777733-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, usuarioWeb, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.777846-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, usuarioWeb, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.777885-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    default int deleteByPrimaryKey(Integer idUsuarioWeb_) {
        return delete(c -> 
            c.where(idUsuarioWeb, isEqualTo(idUsuarioWeb_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.777915-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    default int insert(UsuarioWeb row) {
        return MyBatis3Utils.insert(this::insert, row, usuarioWeb, c ->
            c.map(idUsuarioWeb).toProperty("idUsuarioWeb")
            .map(correo).toProperty("correo")
            .map(contrasena).toProperty("contrasena")
            .map(nombres).toProperty("nombres")
            .map(apellidos).toProperty("apellidos")
            .map(idRolWeb).toProperty("idRolWeb")
            .map(idEstatus).toProperty("idEstatus")
            .map(fechaCreacionBd).toProperty("fechaCreacionBd")
            .map(fechaUltimoMovimiento).toProperty("fechaUltimoMovimiento")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.778006-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    default int insertMultiple(Collection<UsuarioWeb> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, usuarioWeb, c ->
            c.map(idUsuarioWeb).toProperty("idUsuarioWeb")
            .map(correo).toProperty("correo")
            .map(contrasena).toProperty("contrasena")
            .map(nombres).toProperty("nombres")
            .map(apellidos).toProperty("apellidos")
            .map(idRolWeb).toProperty("idRolWeb")
            .map(idEstatus).toProperty("idEstatus")
            .map(fechaCreacionBd).toProperty("fechaCreacionBd")
            .map(fechaUltimoMovimiento).toProperty("fechaUltimoMovimiento")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.778091-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    default int insertSelective(UsuarioWeb row) {
        return MyBatis3Utils.insert(this::insert, row, usuarioWeb, c ->
            c.map(idUsuarioWeb).toPropertyWhenPresent("idUsuarioWeb", row::getIdUsuarioWeb)
            .map(correo).toPropertyWhenPresent("correo", row::getCorreo)
            .map(contrasena).toPropertyWhenPresent("contrasena", row::getContrasena)
            .map(nombres).toPropertyWhenPresent("nombres", row::getNombres)
            .map(apellidos).toPropertyWhenPresent("apellidos", row::getApellidos)
            .map(idRolWeb).toPropertyWhenPresent("idRolWeb", row::getIdRolWeb)
            .map(idEstatus).toPropertyWhenPresent("idEstatus", row::getIdEstatus)
            .map(fechaCreacionBd).toPropertyWhenPresent("fechaCreacionBd", row::getFechaCreacionBd)
            .map(fechaUltimoMovimiento).toPropertyWhenPresent("fechaUltimoMovimiento", row::getFechaUltimoMovimiento)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.778392-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    default Optional<UsuarioWeb> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, usuarioWeb, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.778451-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    default List<UsuarioWeb> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, usuarioWeb, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.778494-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    default List<UsuarioWeb> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, usuarioWeb, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.778537-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    default Optional<UsuarioWeb> selectByPrimaryKey(Integer idUsuarioWeb_) {
        return selectOne(c ->
            c.where(idUsuarioWeb, isEqualTo(idUsuarioWeb_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.77857-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, usuarioWeb, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.77861-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    static UpdateDSL<UpdateModel> updateAllColumns(UsuarioWeb row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(idUsuarioWeb).equalTo(row::getIdUsuarioWeb)
                .set(correo).equalTo(row::getCorreo)
                .set(contrasena).equalTo(row::getContrasena)
                .set(nombres).equalTo(row::getNombres)
                .set(apellidos).equalTo(row::getApellidos)
                .set(idRolWeb).equalTo(row::getIdRolWeb)
                .set(idEstatus).equalTo(row::getIdEstatus)
                .set(fechaCreacionBd).equalTo(row::getFechaCreacionBd)
                .set(fechaUltimoMovimiento).equalTo(row::getFechaUltimoMovimiento);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.778686-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UsuarioWeb row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(idUsuarioWeb).equalToWhenPresent(row::getIdUsuarioWeb)
                .set(correo).equalToWhenPresent(row::getCorreo)
                .set(contrasena).equalToWhenPresent(row::getContrasena)
                .set(nombres).equalToWhenPresent(row::getNombres)
                .set(apellidos).equalToWhenPresent(row::getApellidos)
                .set(idRolWeb).equalToWhenPresent(row::getIdRolWeb)
                .set(idEstatus).equalToWhenPresent(row::getIdEstatus)
                .set(fechaCreacionBd).equalToWhenPresent(row::getFechaCreacionBd)
                .set(fechaUltimoMovimiento).equalToWhenPresent(row::getFechaUltimoMovimiento);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.779371-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    default int updateByPrimaryKey(UsuarioWeb row) {
        return update(c ->
            c.set(correo).equalTo(row::getCorreo)
            .set(contrasena).equalTo(row::getContrasena)
            .set(nombres).equalTo(row::getNombres)
            .set(apellidos).equalTo(row::getApellidos)
            .set(idRolWeb).equalTo(row::getIdRolWeb)
            .set(idEstatus).equalTo(row::getIdEstatus)
            .set(fechaCreacionBd).equalTo(row::getFechaCreacionBd)
            .set(fechaUltimoMovimiento).equalTo(row::getFechaUltimoMovimiento)
            .where(idUsuarioWeb, isEqualTo(row::getIdUsuarioWeb))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.779711-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    default int updateByPrimaryKeySelective(UsuarioWeb row) {
        return update(c ->
            c.set(correo).equalToWhenPresent(row::getCorreo)
            .set(contrasena).equalToWhenPresent(row::getContrasena)
            .set(nombres).equalToWhenPresent(row::getNombres)
            .set(apellidos).equalToWhenPresent(row::getApellidos)
            .set(idRolWeb).equalToWhenPresent(row::getIdRolWeb)
            .set(idEstatus).equalToWhenPresent(row::getIdEstatus)
            .set(fechaCreacionBd).equalToWhenPresent(row::getFechaCreacionBd)
            .set(fechaUltimoMovimiento).equalToWhenPresent(row::getFechaUltimoMovimiento)
            .where(idUsuarioWeb, isEqualTo(row::getIdUsuarioWeb))
        );
    }

	@SelectProvider(type = UsuarioWebDynamicSqlSupport.class, method = "obtenerModeloUsuariosWeb")
	@Results({
		@Result(column = "id_usuario_web", property = "idUsuarioWeb", jdbcType = INTEGER, id = true),
		@Result(column = "correo", property = "correo", jdbcType = VARCHAR),
		@Result(column = "nombres", property = "nombres", jdbcType = VARCHAR),
		@Result(column = "apellidos", property = "apellidos", jdbcType = VARCHAR),
		@Result(column = "id_rol_web", property = "idRolWeb", jdbcType = INTEGER),
		@Result(column = "rol_web", property = "rolWeb", jdbcType = VARCHAR),
		@Result(column = "id_estatus", property = "idEstatus", jdbcType = INTEGER),
		@Result(column = "estatus_usuario", property = "estatusUsuario", jdbcType = VARCHAR),
		@Result(column = "rnum", property = "rnum", jdbcType = INTEGER),
		@Result(column = "totalRecords", property = "totalRecords", jdbcType = INTEGER)
	})
	List<ModeloUsuarioWeb> obtenerModeloUsuariosWeb(BaseFilter filtros);
	
	default Optional<UsuarioWeb> obtenerPorCorreo(String correo_) {
        return selectOne(c ->
            c.where(correo, isEqualTo(correo_))
        );
    }
    
    default Optional<UsuarioWeb> obtenerPorCorreoYEstatus(String correo_, Integer idEstatus_) {
        return selectOne(c ->
            c.where(correo, isEqualTo(correo_))
            .and(idEstatus, isEqualTo(idEstatus_))
        );
    }
	// @formatter:on
}