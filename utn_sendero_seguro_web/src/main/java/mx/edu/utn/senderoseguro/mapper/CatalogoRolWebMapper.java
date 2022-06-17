package mx.edu.utn.senderoseguro.mapper;

import static mx.edu.utn.senderoseguro.mapper.CatalogoRolWebDynamicSqlSupport.catalogoRolWeb;
import static mx.edu.utn.senderoseguro.mapper.CatalogoRolWebDynamicSqlSupport.descripcion;
import static mx.edu.utn.senderoseguro.mapper.CatalogoRolWebDynamicSqlSupport.fechaCreacionBd;
import static mx.edu.utn.senderoseguro.mapper.CatalogoRolWebDynamicSqlSupport.fechaUltimoMovimiento;
import static mx.edu.utn.senderoseguro.mapper.CatalogoRolWebDynamicSqlSupport.idRolWeb;
import static mx.edu.utn.senderoseguro.mapper.CatalogoRolWebDynamicSqlSupport.rolWeb;
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

import mx.edu.utn.senderoseguro.entidad.CatalogoRolWeb;

@Mapper
public interface CatalogoRolWebMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<CatalogoRolWeb>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.754187-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    BasicColumn[] selectList = BasicColumn.columnList(idRolWeb, rolWeb, descripcion, fechaCreacionBd, fechaUltimoMovimiento);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.749999-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CatalogoRolWebResult", value = {
        @Result(column="id_rol_web", property="idRolWeb", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rol_web", property="rolWeb", jdbcType=JdbcType.VARCHAR),
        @Result(column="descripcion", property="descripcion", jdbcType=JdbcType.VARCHAR),
        @Result(column="fecha_creacion_bd", property="fechaCreacionBd", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="fecha_ultimo_movimiento", property="fechaUltimoMovimiento", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CatalogoRolWeb> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.751628-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CatalogoRolWebResult")
    Optional<CatalogoRolWeb> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.751926-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, catalogoRolWeb, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.752004-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, catalogoRolWeb, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.752057-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    default int deleteByPrimaryKey(Integer idRolWeb_) {
        return delete(c -> 
            c.where(idRolWeb, isEqualTo(idRolWeb_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.752099-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    default int insert(CatalogoRolWeb row) {
        return MyBatis3Utils.insert(this::insert, row, catalogoRolWeb, c ->
            c.map(idRolWeb).toProperty("idRolWeb")
            .map(rolWeb).toProperty("rolWeb")
            .map(descripcion).toProperty("descripcion")
            .map(fechaCreacionBd).toProperty("fechaCreacionBd")
            .map(fechaUltimoMovimiento).toProperty("fechaUltimoMovimiento")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.75224-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    default int insertMultiple(Collection<CatalogoRolWeb> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, catalogoRolWeb, c ->
            c.map(idRolWeb).toProperty("idRolWeb")
            .map(rolWeb).toProperty("rolWeb")
            .map(descripcion).toProperty("descripcion")
            .map(fechaCreacionBd).toProperty("fechaCreacionBd")
            .map(fechaUltimoMovimiento).toProperty("fechaUltimoMovimiento")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.753358-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    default int insertSelective(CatalogoRolWeb row) {
        return MyBatis3Utils.insert(this::insert, row, catalogoRolWeb, c ->
            c.map(idRolWeb).toPropertyWhenPresent("idRolWeb", row::getIdRolWeb)
            .map(rolWeb).toPropertyWhenPresent("rolWeb", row::getRolWeb)
            .map(descripcion).toPropertyWhenPresent("descripcion", row::getDescripcion)
            .map(fechaCreacionBd).toPropertyWhenPresent("fechaCreacionBd", row::getFechaCreacionBd)
            .map(fechaUltimoMovimiento).toPropertyWhenPresent("fechaUltimoMovimiento", row::getFechaUltimoMovimiento)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.755416-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    default Optional<CatalogoRolWeb> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, catalogoRolWeb, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.755494-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    default List<CatalogoRolWeb> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, catalogoRolWeb, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.755553-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    default List<CatalogoRolWeb> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, catalogoRolWeb, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.755609-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    default Optional<CatalogoRolWeb> selectByPrimaryKey(Integer idRolWeb_) {
        return selectOne(c ->
            c.where(idRolWeb, isEqualTo(idRolWeb_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.7557-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, catalogoRolWeb, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.75617-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    static UpdateDSL<UpdateModel> updateAllColumns(CatalogoRolWeb row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(idRolWeb).equalTo(row::getIdRolWeb)
                .set(rolWeb).equalTo(row::getRolWeb)
                .set(descripcion).equalTo(row::getDescripcion)
                .set(fechaCreacionBd).equalTo(row::getFechaCreacionBd)
                .set(fechaUltimoMovimiento).equalTo(row::getFechaUltimoMovimiento);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.756765-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(CatalogoRolWeb row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(idRolWeb).equalToWhenPresent(row::getIdRolWeb)
                .set(rolWeb).equalToWhenPresent(row::getRolWeb)
                .set(descripcion).equalToWhenPresent(row::getDescripcion)
                .set(fechaCreacionBd).equalToWhenPresent(row::getFechaCreacionBd)
                .set(fechaUltimoMovimiento).equalToWhenPresent(row::getFechaUltimoMovimiento);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.757545-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    default int updateByPrimaryKey(CatalogoRolWeb row) {
        return update(c ->
            c.set(rolWeb).equalTo(row::getRolWeb)
            .set(descripcion).equalTo(row::getDescripcion)
            .set(fechaCreacionBd).equalTo(row::getFechaCreacionBd)
            .set(fechaUltimoMovimiento).equalTo(row::getFechaUltimoMovimiento)
            .where(idRolWeb, isEqualTo(row::getIdRolWeb))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.757741-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    default int updateByPrimaryKeySelective(CatalogoRolWeb row) {
        return update(c ->
            c.set(rolWeb).equalToWhenPresent(row::getRolWeb)
            .set(descripcion).equalToWhenPresent(row::getDescripcion)
            .set(fechaCreacionBd).equalToWhenPresent(row::getFechaCreacionBd)
            .set(fechaUltimoMovimiento).equalToWhenPresent(row::getFechaUltimoMovimiento)
            .where(idRolWeb, isEqualTo(row::getIdRolWeb))
        );
    }
    
	default List<CatalogoRolWeb> obtenerRolesWeb() {
		return this.select(c -> c.orderBy(rolWeb));
	}
}