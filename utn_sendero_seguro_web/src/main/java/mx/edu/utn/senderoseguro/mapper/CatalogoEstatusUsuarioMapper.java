package mx.edu.utn.senderoseguro.mapper;

import static mx.edu.utn.senderoseguro.mapper.CatalogoEstatusUsuarioDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import mx.edu.utn.senderoseguro.entidad.CatalogoEstatusUsuario;
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

@Mapper
public interface CatalogoEstatusUsuarioMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<CatalogoEstatusUsuario>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.735503-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    BasicColumn[] selectList = BasicColumn.columnList(idEstatusUsuario, estatusUsuario, descripcion, fechaCreacionBd, fechaUltimoMovimiento);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.719429-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CatalogoEstatusUsuarioResult", value = {
        @Result(column="id_estatus_usuario", property="idEstatusUsuario", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="estatus_usuario", property="estatusUsuario", jdbcType=JdbcType.VARCHAR),
        @Result(column="descripcion", property="descripcion", jdbcType=JdbcType.VARCHAR),
        @Result(column="fecha_creacion_bd", property="fechaCreacionBd", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="fecha_ultimo_movimiento", property="fechaUltimoMovimiento", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CatalogoEstatusUsuario> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.720936-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CatalogoEstatusUsuarioResult")
    Optional<CatalogoEstatusUsuario> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.721344-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, catalogoEstatusUsuario, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.72174-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, catalogoEstatusUsuario, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.723478-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    default int deleteByPrimaryKey(Integer idEstatusUsuario_) {
        return delete(c -> 
            c.where(idEstatusUsuario, isEqualTo(idEstatusUsuario_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.724277-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    default int insert(CatalogoEstatusUsuario row) {
        return MyBatis3Utils.insert(this::insert, row, catalogoEstatusUsuario, c ->
            c.map(idEstatusUsuario).toProperty("idEstatusUsuario")
            .map(estatusUsuario).toProperty("estatusUsuario")
            .map(descripcion).toProperty("descripcion")
            .map(fechaCreacionBd).toProperty("fechaCreacionBd")
            .map(fechaUltimoMovimiento).toProperty("fechaUltimoMovimiento")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.729131-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    default int insertMultiple(Collection<CatalogoEstatusUsuario> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, catalogoEstatusUsuario, c ->
            c.map(idEstatusUsuario).toProperty("idEstatusUsuario")
            .map(estatusUsuario).toProperty("estatusUsuario")
            .map(descripcion).toProperty("descripcion")
            .map(fechaCreacionBd).toProperty("fechaCreacionBd")
            .map(fechaUltimoMovimiento).toProperty("fechaUltimoMovimiento")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.731297-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    default int insertSelective(CatalogoEstatusUsuario row) {
        return MyBatis3Utils.insert(this::insert, row, catalogoEstatusUsuario, c ->
            c.map(idEstatusUsuario).toPropertyWhenPresent("idEstatusUsuario", row::getIdEstatusUsuario)
            .map(estatusUsuario).toPropertyWhenPresent("estatusUsuario", row::getEstatusUsuario)
            .map(descripcion).toPropertyWhenPresent("descripcion", row::getDescripcion)
            .map(fechaCreacionBd).toPropertyWhenPresent("fechaCreacionBd", row::getFechaCreacionBd)
            .map(fechaUltimoMovimiento).toPropertyWhenPresent("fechaUltimoMovimiento", row::getFechaUltimoMovimiento)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.736335-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    default Optional<CatalogoEstatusUsuario> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, catalogoEstatusUsuario, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.736662-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    default List<CatalogoEstatusUsuario> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, catalogoEstatusUsuario, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.737669-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    default List<CatalogoEstatusUsuario> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, catalogoEstatusUsuario, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.738388-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    default Optional<CatalogoEstatusUsuario> selectByPrimaryKey(Integer idEstatusUsuario_) {
        return selectOne(c ->
            c.where(idEstatusUsuario, isEqualTo(idEstatusUsuario_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.738955-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, catalogoEstatusUsuario, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.739843-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    static UpdateDSL<UpdateModel> updateAllColumns(CatalogoEstatusUsuario row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(idEstatusUsuario).equalTo(row::getIdEstatusUsuario)
                .set(estatusUsuario).equalTo(row::getEstatusUsuario)
                .set(descripcion).equalTo(row::getDescripcion)
                .set(fechaCreacionBd).equalTo(row::getFechaCreacionBd)
                .set(fechaUltimoMovimiento).equalTo(row::getFechaUltimoMovimiento);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.740977-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(CatalogoEstatusUsuario row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(idEstatusUsuario).equalToWhenPresent(row::getIdEstatusUsuario)
                .set(estatusUsuario).equalToWhenPresent(row::getEstatusUsuario)
                .set(descripcion).equalToWhenPresent(row::getDescripcion)
                .set(fechaCreacionBd).equalToWhenPresent(row::getFechaCreacionBd)
                .set(fechaUltimoMovimiento).equalToWhenPresent(row::getFechaUltimoMovimiento);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.741749-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    default int updateByPrimaryKey(CatalogoEstatusUsuario row) {
        return update(c ->
            c.set(estatusUsuario).equalTo(row::getEstatusUsuario)
            .set(descripcion).equalTo(row::getDescripcion)
            .set(fechaCreacionBd).equalTo(row::getFechaCreacionBd)
            .set(fechaUltimoMovimiento).equalTo(row::getFechaUltimoMovimiento)
            .where(idEstatusUsuario, isEqualTo(row::getIdEstatusUsuario))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.742096-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    default int updateByPrimaryKeySelective(CatalogoEstatusUsuario row) {
        return update(c ->
            c.set(estatusUsuario).equalToWhenPresent(row::getEstatusUsuario)
            .set(descripcion).equalToWhenPresent(row::getDescripcion)
            .set(fechaCreacionBd).equalToWhenPresent(row::getFechaCreacionBd)
            .set(fechaUltimoMovimiento).equalToWhenPresent(row::getFechaUltimoMovimiento)
            .where(idEstatusUsuario, isEqualTo(row::getIdEstatusUsuario))
        );
    }
}