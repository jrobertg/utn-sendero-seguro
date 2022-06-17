package mx.edu.utn.senderoseguro.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class CatalogoTipoUsuarioDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.760049-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    public static final CatalogoTipoUsuario catalogoTipoUsuario = new CatalogoTipoUsuario();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.761712-05:00", comments="Source field: sendero_seguro_schema.catalogo_tipo_usuario.id_tipo_usuario")
    public static final SqlColumn<Integer> idTipoUsuario = catalogoTipoUsuario.idTipoUsuario;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.761859-05:00", comments="Source field: sendero_seguro_schema.catalogo_tipo_usuario.tipo_usuario")
    public static final SqlColumn<String> tipoUsuario = catalogoTipoUsuario.tipoUsuario;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.761957-05:00", comments="Source field: sendero_seguro_schema.catalogo_tipo_usuario.descripcion")
    public static final SqlColumn<String> descripcion = catalogoTipoUsuario.descripcion;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.762007-05:00", comments="Source field: sendero_seguro_schema.catalogo_tipo_usuario.fecha_creacion_bd")
    public static final SqlColumn<LocalDateTime> fechaCreacionBd = catalogoTipoUsuario.fechaCreacionBd;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.762111-05:00", comments="Source field: sendero_seguro_schema.catalogo_tipo_usuario.fecha_ultimo_movimiento")
    public static final SqlColumn<LocalDateTime> fechaUltimoMovimiento = catalogoTipoUsuario.fechaUltimoMovimiento;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.760946-05:00", comments="Source Table: sendero_seguro_schema.catalogo_tipo_usuario")
    public static final class CatalogoTipoUsuario extends AliasableSqlTable<CatalogoTipoUsuario> {
        public final SqlColumn<Integer> idTipoUsuario = column("id_tipo_usuario", JDBCType.INTEGER);

        public final SqlColumn<String> tipoUsuario = column("tipo_usuario", JDBCType.VARCHAR);

        public final SqlColumn<String> descripcion = column("descripcion", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> fechaCreacionBd = column("fecha_creacion_bd", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> fechaUltimoMovimiento = column("fecha_ultimo_movimiento", JDBCType.TIMESTAMP);

        public CatalogoTipoUsuario() {
            super("sendero_seguro_schema.catalogo_tipo_usuario", CatalogoTipoUsuario::new);
        }
    }
}