package mx.edu.utn.senderoseguro.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class CatalogoRolWebDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.748547-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    public static final CatalogoRolWeb catalogoRolWeb = new CatalogoRolWeb();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.748732-05:00", comments="Source field: sendero_seguro_schema.catalogo_rol_web.id_rol_web")
    public static final SqlColumn<Integer> idRolWeb = catalogoRolWeb.idRolWeb;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.748792-05:00", comments="Source field: sendero_seguro_schema.catalogo_rol_web.rol_web")
    public static final SqlColumn<String> rolWeb = catalogoRolWeb.rolWeb;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.74885-05:00", comments="Source field: sendero_seguro_schema.catalogo_rol_web.descripcion")
    public static final SqlColumn<String> descripcion = catalogoRolWeb.descripcion;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.748909-05:00", comments="Source field: sendero_seguro_schema.catalogo_rol_web.fecha_creacion_bd")
    public static final SqlColumn<LocalDateTime> fechaCreacionBd = catalogoRolWeb.fechaCreacionBd;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.748972-05:00", comments="Source field: sendero_seguro_schema.catalogo_rol_web.fecha_ultimo_movimiento")
    public static final SqlColumn<LocalDateTime> fechaUltimoMovimiento = catalogoRolWeb.fechaUltimoMovimiento;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.74864-05:00", comments="Source Table: sendero_seguro_schema.catalogo_rol_web")
    public static final class CatalogoRolWeb extends AliasableSqlTable<CatalogoRolWeb> {
        public final SqlColumn<Integer> idRolWeb = column("id_rol_web", JDBCType.INTEGER);

        public final SqlColumn<String> rolWeb = column("rol_web", JDBCType.VARCHAR);

        public final SqlColumn<String> descripcion = column("descripcion", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> fechaCreacionBd = column("fecha_creacion_bd", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> fechaUltimoMovimiento = column("fecha_ultimo_movimiento", JDBCType.TIMESTAMP);

        public CatalogoRolWeb() {
            super("sendero_seguro_schema.catalogo_rol_web", CatalogoRolWeb::new);
        }
    }
}