package mx.edu.utn.senderoseguro.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class CatalogoEstatusUsuarioDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.716585-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    public static final CatalogoEstatusUsuario catalogoEstatusUsuario = new CatalogoEstatusUsuario();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.717786-05:00", comments="Source field: sendero_seguro_schema.catalogo_estatus_usuario.id_estatus_usuario")
    public static final SqlColumn<Integer> idEstatusUsuario = catalogoEstatusUsuario.idEstatusUsuario;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.718164-05:00", comments="Source field: sendero_seguro_schema.catalogo_estatus_usuario.estatus_usuario")
    public static final SqlColumn<String> estatusUsuario = catalogoEstatusUsuario.estatusUsuario;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.718525-05:00", comments="Source field: sendero_seguro_schema.catalogo_estatus_usuario.descripcion")
    public static final SqlColumn<String> descripcion = catalogoEstatusUsuario.descripcion;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.718637-05:00", comments="Source field: sendero_seguro_schema.catalogo_estatus_usuario.fecha_creacion_bd")
    public static final SqlColumn<LocalDateTime> fechaCreacionBd = catalogoEstatusUsuario.fechaCreacionBd;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.718735-05:00", comments="Source field: sendero_seguro_schema.catalogo_estatus_usuario.fecha_ultimo_movimiento")
    public static final SqlColumn<LocalDateTime> fechaUltimoMovimiento = catalogoEstatusUsuario.fechaUltimoMovimiento;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.717559-05:00", comments="Source Table: sendero_seguro_schema.catalogo_estatus_usuario")
    public static final class CatalogoEstatusUsuario extends AliasableSqlTable<CatalogoEstatusUsuario> {
        public final SqlColumn<Integer> idEstatusUsuario = column("id_estatus_usuario", JDBCType.INTEGER);

        public final SqlColumn<String> estatusUsuario = column("estatus_usuario", JDBCType.VARCHAR);

        public final SqlColumn<String> descripcion = column("descripcion", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> fechaCreacionBd = column("fecha_creacion_bd", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> fechaUltimoMovimiento = column("fecha_ultimo_movimiento", JDBCType.TIMESTAMP);

        public CatalogoEstatusUsuario() {
            super("sendero_seguro_schema.catalogo_estatus_usuario", CatalogoEstatusUsuario::new);
        }
    }
}