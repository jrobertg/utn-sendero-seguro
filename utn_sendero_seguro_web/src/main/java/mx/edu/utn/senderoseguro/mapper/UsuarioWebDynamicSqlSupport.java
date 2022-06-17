package mx.edu.utn.senderoseguro.mapper;

import static java.util.Objects.nonNull;
import static mx.edu.utn.senderoseguro.mapper.Recursos.ESPACIO;

import java.sql.JDBCType;
import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import mx.edu.utn.senderoseguro.web.datatables.BaseFilter;

public final class UsuarioWebDynamicSqlSupport {
	
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.776526-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    public static final UsuarioWeb usuarioWeb = new UsuarioWeb();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.776793-05:00", comments="Source field: sendero_seguro_schema.usuario_web.id_usuario_web")
    public static final SqlColumn<Integer> idUsuarioWeb = usuarioWeb.idUsuarioWeb;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.776851-05:00", comments="Source field: sendero_seguro_schema.usuario_web.correo")
    public static final SqlColumn<String> correo = usuarioWeb.correo;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.776886-05:00", comments="Source field: sendero_seguro_schema.usuario_web.contrasena")
    public static final SqlColumn<String> contrasena = usuarioWeb.contrasena;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.776922-05:00", comments="Source field: sendero_seguro_schema.usuario_web.nombres")
    public static final SqlColumn<String> nombres = usuarioWeb.nombres;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.77696-05:00", comments="Source field: sendero_seguro_schema.usuario_web.apellidos")
    public static final SqlColumn<String> apellidos = usuarioWeb.apellidos;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.776994-05:00", comments="Source field: sendero_seguro_schema.usuario_web.id_rol_web")
    public static final SqlColumn<Integer> idRolWeb = usuarioWeb.idRolWeb;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.777022-05:00", comments="Source field: sendero_seguro_schema.usuario_web.id_estatus")
    public static final SqlColumn<Integer> idEstatus = usuarioWeb.idEstatus;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.777056-05:00", comments="Source field: sendero_seguro_schema.usuario_web.fecha_creacion_bd")
    public static final SqlColumn<LocalDateTime> fechaCreacionBd = usuarioWeb.fechaCreacionBd;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.777088-05:00", comments="Source field: sendero_seguro_schema.usuario_web.fecha_ultimo_movimiento")
    public static final SqlColumn<LocalDateTime> fechaUltimoMovimiento = usuarioWeb.fechaUltimoMovimiento;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.77667-05:00", comments="Source Table: sendero_seguro_schema.usuario_web")
    public static final class UsuarioWeb extends AliasableSqlTable<UsuarioWeb> {
        public final SqlColumn<Integer> idUsuarioWeb = column("id_usuario_web", JDBCType.INTEGER);

        public final SqlColumn<String> correo = column("correo", JDBCType.VARCHAR);

        public final SqlColumn<String> contrasena = column("contrasena", JDBCType.VARCHAR);

        public final SqlColumn<String> nombres = column("nombres", JDBCType.VARCHAR);

        public final SqlColumn<String> apellidos = column("apellidos", JDBCType.VARCHAR);

        public final SqlColumn<Integer> idRolWeb = column("id_rol_web", JDBCType.INTEGER);

        public final SqlColumn<Integer> idEstatus = column("id_estatus", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> fechaCreacionBd = column("fecha_creacion_bd", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> fechaUltimoMovimiento = column("fecha_ultimo_movimiento", JDBCType.TIMESTAMP);

        public UsuarioWeb() {
            super("sendero_seguro_schema.usuario_web", UsuarioWeb::new);
        }
    }

	public String obtenerModeloUsuariosWeb(BaseFilter filtros) {
		final StringBuilder consulta = new StringBuilder();
		consulta
			.append("set search_path = sendero_seguro_schema, extensions;")
			.append(" select")
			.append(" *, count(1) over() as totalRecords, row_number() over() as rnum from")
			.append(" (select")
			.append(" uw.id_usuario_web,")
			.append(" uw.correo,")
			.append(" uw.nombres,")
			.append(" uw.apellidos,")
			.append(" crw.rol_web,")
			.append(" ceu.estatus_usuario,")
			.append(" uw.id_rol_web,")
			.append(" uw.id_estatus")
			.append(" from sendero_seguro_schema.usuario_web uw")
			.append(" inner join sendero_seguro_schema.catalogo_rol_web crw on uw.id_rol_web = crw.id_rol_web")
			.append(" inner join sendero_seguro_schema.catalogo_estatus_usuario ceu on uw.id_estatus = ceu.id_estatus_usuario")
			.append(" where 1 = 1");
		if (nonNull(filtros.getSearch()) && !filtros.getSearch().trim().equals("") && filtros.getSearch().length() > 0) {
			String busqueda = filtros.getSearch().toLowerCase();
			consulta
				.append(" and (")
				.append("unaccent(lower(coalesce(uw.correo, '')")
				.append(" || ' ' || coalesce(uw.nombres, '')")
				.append(" || ' ' || coalesce(uw.apellidos, '')")
				.append(" || ' ' || coalesce(uw.apellidos, '')")
				.append(" || ' ' || coalesce(uw.nombres, '')")
				.append(" || ' ' || crw.rol_web)")
				.append(") like unaccent(lower('%").append(busqueda.trim()).append("%'))")
				.append(")");
		}
		if (nonNull(filtros.getOrden()) && filtros.getOrderBy() > 0) {
			consulta.append(" order by ").append(filtros.getOrderBy() + 1).append(ESPACIO).append(filtros.getOrden());
		} else {
			consulta.append(" order by uw.id_usuario_web desc");
		}
		consulta.append(") t1");
		consulta.append(" limit ").append(filtros.getEnd()).append(" offset ").append(filtros.getStart());
		return consulta.toString();
	}
	
	/*public String activarUsuarios(@Param("idUsuarios") List<Integer> idUsuarios) {
		StringBuilder query = new StringBuilder(0);
		query.append("update sendero_seguro_schema.user set id_status = 1");
		if (nonNull(idUsuarios) && idUsuarios.size() > 0) {
			query.append(" where id in (")
				.append(idUsuarios.stream().map(e -> String.valueOf(e)).collect(joining(",")))
				.append(")");
		} else {
			query.append(" where id = 0");
		}
		return query.toString();
	}
	
	public String inactivarUsuarios(@Param("idUsuarios") List<Integer> idUsuarios) {
		StringBuilder query = new StringBuilder(0);
		query.append("update sendero_seguro_schema.user set id_status = 2");
		if (nonNull(idUsuarios) && idUsuarios.size() > 0) {
			query.append(" where id <> 1 and id in (")
				.append(idUsuarios.stream().map(e -> String.valueOf(e)).collect(joining(",")))
				.append(")");
		} else {
			query.append(" where id = 0");
		}
		return query.toString();
	}*/
}