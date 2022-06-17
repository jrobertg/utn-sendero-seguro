package mx.edu.utn.senderoseguro.entidad;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import lombok.Data;

@Data
public class CatalogoTipoUsuario {
	
	public static final Integer ALUMNO = 1;
	public static final Integer CONDUCTOR = 2;
	public static final Integer TUTOR = 3;
	
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.758983-05:00", comments="Source field: sendero_seguro_schema.catalogo_tipo_usuario.id_tipo_usuario")
    private Integer idTipoUsuario;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.759137-05:00", comments="Source field: sendero_seguro_schema.catalogo_tipo_usuario.tipo_usuario")
    private String tipoUsuario;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.759594-05:00", comments="Source field: sendero_seguro_schema.catalogo_tipo_usuario.descripcion")
    private String descripcion;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.759688-05:00", comments="Source field: sendero_seguro_schema.catalogo_tipo_usuario.fecha_creacion_bd")
    private LocalDateTime fechaCreacionBd;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.75977-05:00", comments="Source field: sendero_seguro_schema.catalogo_tipo_usuario.fecha_ultimo_movimiento")
    private LocalDateTime fechaUltimoMovimiento;
}