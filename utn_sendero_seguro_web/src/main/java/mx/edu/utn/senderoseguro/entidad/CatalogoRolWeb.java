package mx.edu.utn.senderoseguro.entidad;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import lombok.Data;

@Data
public class CatalogoRolWeb {
	
	public final static Integer ADMINISTRADOR = 1;
	public final static Integer VISUALIZADOR = 2;
	
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.747001-05:00", comments="Source field: sendero_seguro_schema.catalogo_rol_web.id_rol_web")
    private Integer idRolWeb;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.747344-05:00", comments="Source field: sendero_seguro_schema.catalogo_rol_web.rol_web")
    private String rolWeb;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.747462-05:00", comments="Source field: sendero_seguro_schema.catalogo_rol_web.descripcion")
    private String descripcion;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.747569-05:00", comments="Source field: sendero_seguro_schema.catalogo_rol_web.fecha_creacion_bd")
    private LocalDateTime fechaCreacionBd;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.747681-05:00", comments="Source field: sendero_seguro_schema.catalogo_rol_web.fecha_ultimo_movimiento")
    private LocalDateTime fechaUltimoMovimiento;
}