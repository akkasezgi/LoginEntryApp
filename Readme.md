Spring Boot ile Kullanıcı Kayıt Formu ve Giriş Formu ile giriş yapılabilen bir uygulamadır.
Maven bagımlılıgı eklendi. 
Model olarak User ve Role modelleri oluşturuldu.
Her kullanıcının bir rol yetkisi olacak.Rol yetkisi ile giriş işlemi sağlanacağı için Rol modeli oluşturuldu. User class’ı ile Rol ilişkisi ManyToMany bir ilişkidir.
JPA Repository oluşturuldu. JPA Repository ile veritabanı ile iletişimin sağlanacağı bir interface oluşturuldu. Bu interface’i extend ederek veritabanı entitylerin interfaceleri yazıldı. UserRepository ve RoleRepositroy oluşturuldu ve bu iki class da JpaRepository’den extend olacak.
Spring Data ile repository classlardaki alanları yazarak sorgu işlemi yapılabiliyor.
Servis katmanında yapılacak işlemlerin amacı veritabanındaki kullanıcı bilgileri ile kullanıcı formu tarafından gelecek olan bilgilerin karşılaştırılmasıdır. kullanıcı kayıt sayfasından gelecek bilgilerin ise kayıt edilmesi sağlamaktadır.
Oluşturacağımız diğer bir Servis ise kullanıcı giriş yapmak istediğinde yetkilendirme işlemin gerçekleşeceği classtır. Bu class UserDetailsService Spring Security kütüphanesinden implement edilerek metodları Override ederek kullanılıyor. Yetkilendirme işlemlerini ve kullanıcı yönetim işlemlerini Spring Security’e veriyoruz. loadUserByUsername Sadece kullanıcı sorgulayıcı metodunda userRepository.findByUsername ile kullanıcıyı bulunuyor. getAuthorities metodu ile de kullanıcıya ait rollerin veritabanından alınmasını sağlayarak Spring’e verilmesi sağlanmış oluyor.
Web sayfası ile Java sınıfları arasında iletişim sağlayacak, köprü olacak Controller sınıfı oluşturuldu.
Controller sınıfında web sayfalarının hangi url’de hangi sayfalara gideceğini, POST, GET işlemlerinde yapılacak işlemleri yapılacak.
Controller sayfasında, registerPage kayıt sayfasını gösterir. saveRegisterPage ise kullanıcı kayıt sayfasından gelen verileri alarak service üzerinden kaydeder.  Kullanıcı kayıt işleminde gelen veride bir sorun var ise  if (result.hasErrors()) kontrol ederek kayıt işleminde geçmeden kayıt sayfasında tekrar yönlendirerek işlemlerin kaldığı yerden devam etmesi sağlanmaktadır.


Spring Framework konusunda öğrenimim devam etmektedir. Gelişmeye devam ediyorum. Uygulamanın bu dikkatle okunmasını rica ederim.

