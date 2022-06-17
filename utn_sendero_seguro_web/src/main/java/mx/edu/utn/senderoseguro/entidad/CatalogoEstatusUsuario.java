package mx.edu.utn.senderoseguro.entidad;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import lombok.Data;

@Data
public class CatalogoEstatusUsuario {
	
	public static final Integer ACTIVO = 1;
	public static final Integer INACTIVO = 2;
	
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.70332-05:00", comments="Source field: sendero_seguro_schema.catalogo_estatus_usuario.id_estatus_usuario")
    private Integer idEstatusUsuario;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.712389-05:00", comments="Source field: sendero_seguro_schema.catalogo_estatus_usuario.estatus_usuario")
    private String estatusUsuario;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.712636-05:00", comments="Source field: sendero_seguro_schema.catalogo_estatus_usuario.descripcion")
    private String descripcion;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.712853-05:00", comments="Source field: sendero_seguro_schema.catalogo_estatus_usuario.fecha_creacion_bd")
    private LocalDateTime fechaCreacionBd;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.71325-05:00", comments="Source field: sendero_seguro_schema.catalogo_estatus_usuario.fecha_ultimo_movimiento")
    private LocalDateTime fechaUltimoMovimiento;
}