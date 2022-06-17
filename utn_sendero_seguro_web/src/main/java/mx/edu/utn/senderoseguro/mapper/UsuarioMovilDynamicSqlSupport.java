package mx.edu.utn.senderoseguro.mapper;

import static java.util.Objects.nonNull;
import static mx.edu.utn.senderoseguro.mapper.Recursos.ESPACIO;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import mx.edu.utn.senderoseguro.web.datatables.BaseFilter;

public final class UsuarioMovilDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.76889-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    public static final UsuarioMovil usuarioMovil = new UsuarioMovil();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.769368-05:00", comments="Source field: sendero_seguro_schema.usuario_movil.id_usuario_movil")
    public static final SqlColumn<Integer> idUsuarioMovil = usuarioMovil.idUsuarioMovil;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.769421-05:00", comments="Source field: sendero_seguro_schema.usuario_movil.correo")
    public static final SqlColumn<String> correo = usuarioMovil.correo;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.76954-05:00", comments="Source field: sendero_seguro_schema.usuario_movil.contrasena")
    public static final SqlColumn<String> contrasena = usuarioMovil.contrasena;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.769652-05:00", comments="Source field: sendero_seguro_schema.usuario_movil.nombres")
    public static final SqlColumn<String> nombres = usuarioMovil.nombres;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.769711-05:00", comments="Source field: sendero_seguro_schema.usuario_movil.apellidos")
    public static final SqlColumn<String> apellidos = usuarioMovil.apellidos;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.769765-05:00", comments="Source field: sendero_seguro_schema.usuario_movil.id_tipo_usuario")
    public static final SqlColumn<Integer> idTipoUsuario = usuarioMovil.idTipoUsuario;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.769802-05:00", comments="Source field: sendero_seguro_schema.usuario_movil.id_estatus")
    public static final SqlColumn<Integer> idEstatus = usuarioMovil.idEstatus;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.77017-05:00", comments="Source field: sendero_seguro_schema.usuario_movil.fecha_creacion_bd")
    public static final SqlColumn<LocalDateTime> fechaCreacionBd = usuarioMovil.fechaCreacionBd;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.77024-05:00", comments="Source field: sendero_seguro_schema.usuario_movil.fecha_ultimo_movimiento")
    public static final SqlColumn<LocalDateTime> fechaUltimoMovimiento = usuarioMovil.fechaUltimoMovimiento;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.769294-05:00", comments="Source Table: sendero_seguro_schema.usuario_movil")
    public static final class UsuarioMovil extends AliasableSqlTable<UsuarioMovil> {
        public final SqlColumn<Integer> idUsuarioMovil = column("id_usuario_movil", JDBCType.INTEGER);

        public final SqlColumn<String> correo = column("correo", JDBCType.VARCHAR);

        public final SqlColumn<String> contrasena = column("contrasena", JDBCType.VARCHAR);

        public final SqlColumn<String> nombres = column("nombres", JDBCType.VARCHAR);

        public final SqlColumn<String> apellidos = column("apellidos", JDBCType.VARCHAR);

        public final SqlColumn<Integer> idTipoUsuario = column("id_tipo_usuario", JDBCType.INTEGER);

        public final SqlColumn<Integer> idEstatus = column("id_estatus", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> fechaCreacionBd = column("fecha_creacion_bd", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> fechaUltimoMovimiento = column("fecha_ultimo_movimiento", JDBCType.TIMESTAMP);

        public UsuarioMovil() {
            super("sendero_seguro_schema.usuario_movil", UsuarioMovil::new);
        }
    }
    
    public String obtenerModeloUsuariosMovil(BaseFilter filtros) {
		final StringBuilder consulta = new StringBuilder();
		consulta
			.append("set search_path = sendero_seguro_schema, extensions;")
			.append(" select")
			.append(" *, COUNT(1) OVER() AS totalRecords, ROW_NUMBER() OVER () AS rnum from")
			.append(" (select")
			.append(" um.id_usuario_movil,")
			.append(" um.correo,")
			.append(" um.nombres,")
			.append(" um.apellidos,")
			.append(" ctu.tipo_usuario,")
			.append(" ceu.estatus_usuario,")
			.append(" um.id_tipo_usuario,")
			.append(" um.id_estatus")
			.append(" from sendero_seguro_schema.usuario_movil um")
			.append(" inner join sendero_seguro_schema.catalogo_tipo_usuario ctu on um.id_tipo_usuario = ctu.id_tipo_usuario")
			.append(" inner join sendero_seguro_schema.catalogo_estatus_usuario ceu on um.id_estatus = ceu.id_estatus_usuario")
			.append(" where 1 = 1");
		if (nonNull(filtros.getSearch()) && !filtros.getSearch().trim().equals("") && filtros.getSearch().length() > 0) {
			String busqueda = filtros.getSearch().toLowerCase();
			consulta
				.append(" and (")
				.append("unaccent(lower(coalesce(um.correo,'')")
				.append(" || ' ' || coalesce(um.nombres, '')")
				.append(" || ' ' || coalesce(um.apellidos, '')")
				.append(" || ' ' || coalesce(um.apellidos, '')")
				.append(" || ' ' || coalesce(um.nombres, '')")
				.append(" || ' ' || ctu.tipo_usuario)")
				.append(") like unaccent(lower('%").append(busqueda.trim()).append("%'))")
				.append(")");
		}
		if (nonNull(filtros.getOrden()) && filtros.getOrderBy() > 0) {
			consulta.append(" order by ").append(filtros.getOrderBy() + 1).append(ESPACIO).append(filtros.getOrden());
		} else {
			consulta.append(" order by um.id_usuario_movil desc");
		}
		consulta.append(") t1");
		consulta.append(" limit ").append(filtros.getEnd()).append(" offset ").append(filtros.getStart());
		return consulta.toString();
	}
}