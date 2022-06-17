package mx.edu.utn.senderoseguro.entidad;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UsuarioMovil {
	
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.765501-05:00", comments="Source field: sendero_seguro_schema.usuario_movil.id_usuario_movil")
    private Integer idUsuarioMovil;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.765612-05:00", comments="Source field: sendero_seguro_schema.usuario_movil.correo")
    private String correo;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.7657-05:00", comments="Source field: sendero_seguro_schema.usuario_movil.contrasena")
    private String contrasena;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.765794-05:00", comments="Source field: sendero_seguro_schema.usuario_movil.nombres")
    private String nombres;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.767115-05:00", comments="Source field: sendero_seguro_schema.usuario_movil.apellidos")
    private String apellidos;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.767395-05:00", comments="Source field: sendero_seguro_schema.usuario_movil.id_tipo_usuario")
    private Integer idTipoUsuario;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.767472-05:00", comments="Source field: sendero_seguro_schema.usuario_movil.id_estatus")
    private Integer idEstatus;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.767541-05:00", comments="Source field: sendero_seguro_schema.usuario_movil.fecha_creacion_bd")
    private LocalDateTime fechaCreacionBd;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-06T09:51:07.767669-05:00", comments="Source field: sendero_seguro_schema.usuario_movil.fecha_ultimo_movimiento")
    private LocalDateTime fechaUltimoMovimiento;
}