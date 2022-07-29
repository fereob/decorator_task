/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oscarblancarte.ipd.decorator.impl.decorators;

import oscarblancarte.ipd.decorator.impl.message.IMessage;

/**
 *
 * @author Fernando
 */
public class FooterDecorator extends MessageDecorator{
    
    private String name, direction, email, telephone;
    
    public FooterDecorator(String name, String direction, String email, String telephone, IMessage message){
        super(message);
        this.name = name;
        this.direction = direction;
        this.email = email;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    @Override
    public IMessage processMessage(){
        message = message.processMessage();
        message = wrapMessage();
        return message;
    }
        
    private IMessage wrapMessage(){
        String footer = message.getContent() + "\n"
                + " <sopaenv:Footer>\n"
                + "     Empresa: " + name + "\n"
                + "     Direccion: " + direction + "\n"
                + "     Telefono: " + telephone + "\n"
                + " </soapenv:Footer>\n";
        message.setContent(footer);
        return message;
    }
    
}
