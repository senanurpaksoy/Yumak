????   4 m
      javax/swing/JFrame paint (Ljava/awt/Graphics;)V	  	 
   
yumak/Game objs Lyumak/GameObjects;
    yumak/GameObjects
     <init> ()V
  
     setSize (II)V
     setDefaultCloseOperation (I)V
      setResizable (Z)V
  " # $ setLocationRelativeTo (Ljava/awt/Component;)V
  & '   
setVisible
 ) * + , - java/lang/Math random ()D@9      @      
  3 4  generateObj
  6 7  repaint       

 ; < = > ? java/lang/Thread sleep (J)V A java/lang/InterruptedException
 C D E F G java/lang/Class getName ()Ljava/lang/String;
 I J K L M java/util/logging/Logger 	getLogger .(Ljava/lang/String;)Ljava/util/logging/Logger;	 O P Q R S java/util/logging/Level SEVERE Ljava/util/logging/Level;
 I U V W log C(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V EKRANBOYUTU I ConstantValue  X cat Lyumak/TheCat; Code LineNumberTable LocalVariableTable this Lyumak/Game; g Ljava/awt/Graphics; MethodParameters init run ex  Ljava/lang/InterruptedException; StackMapTable 
SourceFile 	Game.java !       X Y  Z    [  \ ]             ^   J     *+? *? +? ?    _            `        a b      c d  e    c       ^   B     *? *? Y? ? ?    _           + `        a b    f   ^   ]     *XX? *? *? *? !*? %?    _       / 
 0  1  2  3  4 `        a b    g   ^   ?     <? ( .k?? *? ? ( 0k?? 2*? 5 8? :???L? B? H? N+? T???   % ( @  _   "    :  <  A  M % P ( N ) O 9 P `     )  h i    < a b   j     L @  k    l