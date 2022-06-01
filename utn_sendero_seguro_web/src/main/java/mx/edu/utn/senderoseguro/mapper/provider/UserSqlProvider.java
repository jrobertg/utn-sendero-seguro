package mx.edu.utn.senderoseguro.mapper.provider;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.joining;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import mx.edu.utn.senderoseguro.web.datatables.BaseFilter;

public class UserSqlProvider {
	
	private static final String ESPACIO = " ";

	public String obtenerConsultaModeloUsuarios(BaseFilter filtros) {
		final StringBuilder consulta = new StringBuilder();
		consulta
			.append("set search_path = sendero_seguro_schema, extensions;")
			.append(" select")
			.append(" *, COUNT(1) OVER() AS totalRecords, ROW_NUMBER() OVER () AS rnum from")
			.append(" (select")
			.append(" u.id,")
			.append(" u.email,")
			.append(" u.first_name,")
			.append(" u.last_name,")
			.append(" u.id_status")
			.append(" from sendero_seguro_schema.user u")
			.append(" where 1 = 1");
		if (nonNull(filtros.getSearch()) && !filtros.getSearch().trim().equals("") && filtros.getSearch().length() > 0) {
			String busqueda = filtros.getSearch().toLowerCase();
			consulta
				.append(" AND (")
				.append("unaccent(lower(coalesce(u.email,'')")
				.append(" || ' ' || coalesce(u.first_name, '')")
				.append(" || ' ' || coalesce(u.last_name, '')")
				.append(" || ' ' || coalesce(u.last_name, '')")
				.append(" || ' ' || coalesce(u.first_name, ''))")
				.append(") LIKE unaccent(lower('%").append(busqueda.trim()).append("%'))")
				.append(")");
		}
		if (nonNull(filtros.getOrden()) && filtros.getOrderBy() > 0) {
			consulta.append(" order by ").append(filtros.getOrderBy() + 1).append(ESPACIO).append(filtros.getOrden());
		} else {
			consulta.append(" order by u.id desc");
		}
		consulta.append(") t1");
		consulta.append(" limit ").append(filtros.getEnd()).append(" offset ").append(filtros.getStart());
		return consulta.toString();
	}
	
	public String activarUsuarios(@Param("idUsuarios") List<Integer> idUsuarios) {
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
	}

}
