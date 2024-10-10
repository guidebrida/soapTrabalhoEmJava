package org.example.client;

import org.example.client.service.Order;
import org.example.client.service.OrderService;
import org.example.client.service.OrderServiceService;
import org.example.client.service.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static OrderService orderService;

    public static void main(String[] args) {
        OrderServiceService service = new OrderServiceService();
        orderService = service.getOrderServicePort();

        // Cria a janela do menu principal
        JFrame menuFrame = new JFrame("Menu Principal");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(400, 200);
        menuFrame.setLayout(new GridLayout(3, 1)); // 3 linhas, 1 coluna

        // Botão para criar uma nova ordem
        JButton criarOrdemButton = new JButton("Criar Nova Ordem");
        criarOrdemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarNovaOrdem();
            }
        });

        // Botão para exibir ordens
        JButton exibirOrdensButton = new JButton("Exibir Ordens");
        exibirOrdensButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirOrdens();
            }
        });

        JButton excluirOrdemPorId = new JButton("Excluir OS");
        excluirOrdemPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirporId();
            }
        });

        // Botão para sair
        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Adiciona os botões à janela
        menuFrame.add(criarOrdemButton);
        menuFrame.add(exibirOrdensButton);
        menuFrame.add(excluirOrdemPorId);
        menuFrame.add(sairButton);

        // Exibe o menu principal
        menuFrame.setVisible(true);
    }

    private static void criarNovaOrdem() {
        List<Product> products = new ArrayList<>();

        JFrame frame = new JFrame("Criar Nova Ordem");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS)); // Alinha verticalmente

        JTextField productNameField = new JTextField(10);
        JTextField quantidadeField = new JTextField(5);
        JTextField enderecoField = new JTextField(20);
        JTextField statusField = new JTextField(10);

        // Botão para criar a ordem
        JButton jButtonCriarOrdem = new JButton("Criar Ordem");
        jButtonCriarOrdem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = productNameField.getText();
                Integer quantidade = Integer.valueOf(quantidadeField.getText());
                String endereco = enderecoField.getText();
                String status = statusField.getText();

                Product product = new Product();
                product.setProductName(productName);
                product.setId(products.size() + 1);
                product.setQuantidade(quantidade);
                products.add(product);
                Order order = new Order();
                order.setId(obterNovoId());
                order.setEndereco(endereco);
                order.setStatus(status);
                order.getProducts().addAll(products);
                orderService.create(order);
                productNameField.setText("");
                quantidadeField.setText("");
                enderecoField.setText("");
                statusField.setText("");

                JOptionPane.showMessageDialog(frame, "Ordem criada com sucesso!");
            }
        });

        JButton jButtonRetornar = new JButton("Retornar");
        jButtonRetornar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        // Adiciona os componentes ao frame, agora organizados verticalmente
        frame.add(new JLabel("Produto:"));
        frame.add(productNameField);
        frame.add(new JLabel("Quantidade:"));
        frame.add(quantidadeField);
        frame.add(new JLabel("Endereço:"));
        frame.add(enderecoField);
        frame.add(new JLabel("Status:"));
        frame.add(statusField);
        frame.add(jButtonCriarOrdem);
        frame.add(jButtonRetornar);

        frame.setVisible(true);
    }

    private static int obterNovoId() {
        List<Order> orders = orderService.getAll();
        return orders.stream()
                .mapToInt(Order::getId)
                .max()
                .orElse(0) + 1;
    }

    private static void exibirOrdens() {
        // Busca as ordens diretamente do servidor SOAP
        List<Order> orderList = orderService.getAll(); // Supondo que o serviço tem um método 'getOrders()'

        if (orderList == null || orderList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma ordem criada.");
            return;
        }

        StringBuilder ordens = new StringBuilder();
        for (Order order : orderList) {
            ordens.append("ID: ").append(order.getId()).append("\n");
            ordens.append("Status: ").append(order.getStatus()).append("\n");
            ordens.append("Endereço: ").append(order.getEndereco()).append("\n");
            ordens.append("Produtos:\n");
            for (Product product : order.getProducts()) {
                ordens.append("- ").append(product.getProductName())
                        .append(" (Quantidade: ").append(product.getQuantidade()).append(")\n");
            }
            ordens.append("\n");
        }
        JOptionPane.showMessageDialog(null, ordens.toString(), "Ordens Criadas", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void excluirporId() {
        JFrame frame = new JFrame("Excluir Ordem");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        JLabel labelId = new JLabel("Insira o ID da Ordem a ser excluída:");
        JTextField idField = new JTextField(10);

        JButton excluirButton = new JButton("Excluir");

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int orderId = Integer.parseInt(idField.getText());

                    // Chama o serviço SOAP para deletar a ordem com o ID fornecido
                    orderService.delete(orderId); // Supondo que o serviço tenha o método delete

                    JOptionPane.showMessageDialog(frame, "Ordem excluída com sucesso!");

                    frame.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "ID inválido. Por favor, insira um número válido.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erro ao excluir a ordem: " + ex.getMessage());
                }
            }
        });

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        // Adiciona os componentes ao frame
        frame.add(labelId);
        frame.add(idField);
        frame.add(excluirButton);
        frame.add(cancelarButton);

        // Torna o frame visível
        frame.setVisible(true);
    }

}
