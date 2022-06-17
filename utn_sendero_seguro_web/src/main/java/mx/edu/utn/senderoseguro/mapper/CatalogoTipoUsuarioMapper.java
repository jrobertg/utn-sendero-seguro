package mx.edu.utn.senderoseguro.mapper;

import static mx.edu.utn.senderoseguro.mapper.CatalogoTipoUsuarioDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import mx.edu.utn.senderoseguro.entidad.CatalogoTipoUsuario;
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
public interface CatalogoTipoUsuarioMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<CatalogoTipoUsuario>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.76323-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    BasicColumn[] selectList = BasicColumn.columnList(idTipoUsuario, tipoUsuario, descripcion, fechaCreacionBd, fechaUltimoMovimiento);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.76237-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CatalogoTipoUsuarioResult", value = {
        @Result(column="id_tipo_usuario", property="idTipoUsuario", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tipo_usuario", property="tipoUsuario", jdbcType=JdbcType.VARCHAR),
        @Result(column="descripcion", property="descripcion", jdbcType=JdbcType.VARCHAR),
        @Result(column="fecha_creacion_bd", property="fechaCreacionBd", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="fecha_ultimo_movimiento", property="fechaUltimoMovimiento", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CatalogoTipoUsuario> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.762498-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CatalogoTipoUsuarioResult")
    Optional<CatalogoTipoUsuario> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.762557-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, catalogoTipoUsuario, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.762607-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, catalogoTipoUsuario, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.762663-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    default int deleteByPrimaryKey(Integer idTipoUsuario_) {
        return delete(c -> 
            c.where(idTipoUsuario, isEqualTo(idTipoUsuario_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.76271-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    default int insert(CatalogoTipoUsuario row) {
        return MyBatis3Utils.insert(this::insert, row, catalogoTipoUsuario, c ->
            c.map(idTipoUsuario).toProperty("idTipoUsuario")
            .map(tipoUsuario).toProperty("tipoUsuario")
            .map(descripcion).toProperty("descripcion")
            .map(fechaCreacionBd).toProperty("fechaCreacionBd")
            .map(fechaUltimoMovimiento).toProperty("fechaUltimoMovimiento")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.762935-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    default int insertMultiple(Collection<CatalogoTipoUsuario> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, catalogoTipoUsuario, c ->
            c.map(idTipoUsuario).toProperty("idTipoUsuario")
            .map(tipoUsuario).toProperty("tipoUsuario")
            .map(descripcion).toProperty("descripcion")
            .map(fechaCreacionBd).toProperty("fechaCreacionBd")
            .map(fechaUltimoMovimiento).toProperty("fechaUltimoMovimiento")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.7631-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    default int insertSelective(CatalogoTipoUsuario row) {
        return MyBatis3Utils.insert(this::insert, row, catalogoTipoUsuario, c ->
            c.map(idTipoUsuario).toPropertyWhenPresent("idTipoUsuario", row::getIdTipoUsuario)
            .map(tipoUsuario).toPropertyWhenPresent("tipoUsuario", row::getTipoUsuario)
            .map(descripcion).toPropertyWhenPresent("descripcion", row::getDescripcion)
            .map(fechaCreacionBd).toPropertyWhenPresent("fechaCreacionBd", row::getFechaCreacionBd)
            .map(fechaUltimoMovimiento).toPropertyWhenPresent("fechaUltimoMovimiento", row::getFechaUltimoMovimiento)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.763286-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    default Optional<CatalogoTipoUsuario> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, catalogoTipoUsuario, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.763339-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    default List<CatalogoTipoUsuario> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, catalogoTipoUsuario, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.763387-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    default List<CatalogoTipoUsuario> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, catalogoTipoUsuario, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.763434-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    default Optional<CatalogoTipoUsuario> selectByPrimaryKey(Integer idTipoUsuario_) {
        return selectOne(c ->
            c.where(idTipoUsuario, isEqualTo(idTipoUsuario_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.763473-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, catalogoTipoUsuario, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.763825-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    static UpdateDSL<UpdateModel> updateAllColumns(CatalogoTipoUsuario row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(idTipoUsuario).equalTo(row::getIdTipoUsuario)
                .set(tipoUsuario).equalTo(row::getTipoUsuario)
                .set(descripcion).equalTo(row::getDescripcion)
                .set(fechaCreacionBd).equalTo(row::getFechaCreacionBd)
                .set(fechaUltimoMovimiento).equalTo(row::getFechaUltimoMovimiento);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.764818-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(CatalogoTipoUsuario row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(idTipoUsuario).equalToWhenPresent(row::getIdTipoUsuario)
                .set(tipoUsuario).equalToWhenPresent(row::getTipoUsuario)
                .set(descripcion).equalToWhenPresent(row::getDescripcion)
                .set(fechaCreacionBd).equalToWhenPresent(row::getFechaCreacionBd)
                .set(fechaUltimoMovimiento).equalToWhenPresent(row::getFechaUltimoMovimiento);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.765005-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    default int updateByPrimaryKey(CatalogoTipoUsuario row) {
        return update(c ->
            c.set(tipoUsuario).equalTo(row::getTipoUsuario)
            .set(descripcion).equalTo(row::getDescripcion)
            .set(fechaCreacionBd).equalTo(row::getFechaCreacionBd)
            .set(fechaUltimoMovimiento).equalTo(row::getFechaUltimoMovimiento)
            .where(idTipoUsuario, isEqualTo(row::getIdTipoUsuario))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.765084-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    default int updateByPrimaryKeySelective(CatalogoTipoUsuario row) {
        return update(c ->
            c.set(tipoUsuario).equalToWhenPresent(row::getTipoUsuario)
            .set(descripcion).equalToWhenPresent(row::getDescripcion)
            .set(fechaCreacionBd).equalToWhenPresent(row::getFechaCreacionBd)
            .set(fechaUltimoMovimiento).equalToWhenPresent(row::getFechaUltimoMovimiento)
            .where(idTipoUsuario, isEqualTo(row::getIdTipoUsuario))
        );
    }
}