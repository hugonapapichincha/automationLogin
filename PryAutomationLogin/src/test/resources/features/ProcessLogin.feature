Feature: Proceso de Login para acceso a aplicación Home Banking
  Esta caracteristica de Home Banking es el proceso principal de la aplicación
  que permite el ingreso a la aplicación y a todas sus opciones.

  Scenario: Realizar login exitoso
    Ingresar a la aplicación para validar el flujo login para un cliente con una cuenta activa mediante usuario y clave digital correcto .

    Given   El cliente abre la pagina de HBK
    When    Se ingresa el usuario "<usuario>" y password "<password>"
    Then    Clic en boton iniciar sesion e ingresa al Home
    Examples: Parametros de entrada usuario y password
    | usuario | password |
    | 1       | 1        |

  Scenario: Realizar login con usuario errado y password correcto
    Ingresar a la aplicación para validar el flujo login para un cliente con una cuenta activa mediante usuario errado y clave digital correcto.

    Given   El cliente abre la pagina de HBK
    When    Se ingresa el usuario "<usuario>" y password "<password>"
    Then    Clic en boton iniciar sesion y muestra mensaje "<mensaje>"
    Examples: Datos del usuario y mensaje
    | usuario | password | mensaje |
    | 2       | 2        | 2       |

  Scenario: Realizar login con usuario correcto y password errado
    Ingresar a la aplicación para validar el flujo login para un cliente con una cuenta activa mediante usuario correcto y clave digital incorrecto.

    Given   El cliente abre la pagina de HBK
    When    Se ingresa el usuario "<usuario>" y password "<password>"
    Then    Clic en boton iniciar sesion y muestra mensaje "<mensaje>"
    Examples: Datos del usuario y mensaje
    | usuario | password | mensaje |
    | 3       | 3        | 3       |

  Scenario: Realizar login con usuario estado bloqueado temporal
    Ingresar a la aplicación para validar el flujo login para un usuario con estado "Bloqueo Temporal".

    Given   El cliente abre la pagina de HBK
    When    Se ingresa el usuario "<usuario>" y password "<password>"
    Then    Clic en boton iniciar sesion y muestra mensaje bloqueado "<mensaje>"
    Examples: Datos del usuario con estado bloqueado temporal
    | usuario | password | mensaje |
    | 4       | 4        | 4       |

  Scenario: Realizar login con usuario estado bloqueado nuevo
    Ingresar a la aplicación para validar el flujo login para un usuario con estado "Bloqueado Nuevo".

    Given   El cliente abre la pagina de HBK
    When    Se ingresa el usuario "<usuario>" y password "<password>"
    Then    Clic en boton iniciar sesion y muestra mensaje bloqueado "<mensaje>"
    Examples: Datos del usuario con estado bloqueado nuevo
    | usuario | password | mensaje |
    | 5       | 5        | 5       |

  Scenario: Realizar login con usuario activo y tarjeta activa
    Ingresar a la aplicación para validar el flujo login del usuario digital activo y la tarjeta de debito activa.

    Given   El cliente abre la pagina de HBK
    When    Se ingresa el usuario "<usuario>" y password "<password>"
    Then    Clic en boton iniciar sesion e ingresa al Home
    Examples: Parametros de entrada usuario y password
      | usuario | password |
      | 6       | 6        |

  Scenario: Realizar login con usuario activo y tarjeta estado inactivo
    Ingresar a la aplicación para validar el flujo login del usuario digital activo y la tarjeta de debito bloqueada este en estado inactivo.

    Given   El cliente abre la pagina de HBK
    When    Se ingresa el usuario "<usuario>" y password "<password>"
    Then    Clic en boton iniciar sesion y muestra tarjeta bloqueado "<mensaje>"
    Examples: Parametros de entrada usuario y password
      | usuario | password | mensaje |
      | 7       | 7        | 7       |

  Scenario: Realizar login con usuario activo y tarjeta estado cancelada
    Ingresar a la aplicación para validar el flujo login del usuario digital activo y la tarjeta de debito bloqueada este en estado cancelada.

    Given   El cliente abre la pagina de HBK
    When    Se ingresa el usuario "<usuario>" y password "<password>"
    Then    Clic en boton iniciar sesion y muestra tarjeta bloqueado "<mensaje>"
    Examples: Parametros de entrada usuario y password
      | usuario | password | mensaje |
      | 8       | 8        | 8       |

  Scenario: Realizar login con usuario dado de baja
    Ingresar a la aplicación para validar el flujo del usuario dado de baja.

    Given   El cliente abre la pagina de HBK
    When    Se ingresa el usuario "<usuario>" y password "<password>"
    Then    Clic en boton iniciar sesion y muestra mensaje bloqueado "<mensaje>"
    Examples: Parametros de entrada usuario y password
      | usuario | password | mensaje |
      | 9       | 9        | 9       |
