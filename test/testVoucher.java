
import bestdeal.entites.Voucher;
import bestdeal.dao.VoucherDAO;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author youssef
 */
public class testVoucher {
    
    
    
    public static void main(String[]args)
    {
        Voucher v = new Voucher();
        VoucherDAO vo= new VoucherDAO();
        vo.creerPdf();
    }
}
