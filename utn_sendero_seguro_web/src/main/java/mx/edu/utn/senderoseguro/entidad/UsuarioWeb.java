package mx.edu.utn.senderoseguro.entidad;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UsuarioWeb {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.773692-05:00", comments="Source field: sendero_seguro_schema.usuario_web.id_usuario_web")
    private Integer idUsuarioWeb;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.77386-05:00", comments="Source field: sendero_seguro_schema.usuario_web.correo")
    private String correo;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.774111-05:00", comments="Source field: sendero_seguro_schema.usuario_web.contrasena")
    private String contrasena;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.774188-05:00", comments="Source field: sendero_seguro_schema.usuario_web.nombres")
    private String nombres;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.774391-05:00", comments="Source field: sendero_seguro_schema.usuario_web.apellidos")
    private String apellidos;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.774607-05:00", comments="Source field: sendero_seguro_schema.usuario_web.id_rol_web")
    private Integer idRolWeb;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.775436-05:00", comments="Source field: sendero_seguro_schema.usuario_web.id_estatus")
    private Integer idEstatus;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.775551-05:00", comments="Source field: sendero_seguro_schema.usuario_web.fecha_creacion_bd")
    private LocalDateTime fechaCreacionBd;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.775804-05:00", comments="Source field: sendero_seguro_schema.usuario_web.fecha_ultimo_movimiento")
    private LocalDateTime fechaUltimoMovimiento;
}