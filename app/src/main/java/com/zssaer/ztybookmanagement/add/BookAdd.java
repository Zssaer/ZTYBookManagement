package com.zssaer.ztybookmanagement.add;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zssaer.ztybookmanagement.R;
import com.zssaer.ztybookmanagement.bean.Book;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

/**
 * 图书添加页面
 */
public class BookAdd extends AppCompatActivity {
    private Button add_default_book;
    private Button add_book_button;
    private EditText add_name;
    private EditText add_author;
    private EditText add_about;
    private EditText add_price;
    private EditText add_pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_add);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        init();

        add_default_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = LitePal.getDatabase();
                List<Book> books=Default_add_book();
                for (Book book:books) {
                    book.save();
                }
                Toast.makeText(BookAdd.this, "默认图书添加成功！", Toast.LENGTH_SHORT).show();
            }
        });

        add_book_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = LitePal.getDatabase();
                Book book=Add_book();
                book.save();
                Toast.makeText(BookAdd.this, "自定义图书添加成功！", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void init(){
        add_default_book=(Button) findViewById(R.id.add_default_book);
        add_book_button=(Button)findViewById(R.id.add_book);
        add_name=(EditText)findViewById(R.id.add_name);
        add_author=(EditText)findViewById(R.id.add_author);
        add_about=(EditText)findViewById(R.id.add_about);
        add_price=(EditText)findViewById(R.id.add_price);
        add_pages=(EditText)findViewById(R.id.add_pages);

    }

    /**
     * 默认书籍添加
     * @return
     */
    private List<Book> Default_add_book(){
        List<Book> books= new ArrayList<Book>();
        books.add(new Book("天龙八部一", "金庸", "《天龙八部》是中国现代作家金庸创作的长篇武侠小说。这部小说从1963年开始创作，历时4年完成。前后共有三版，并在2005年第三版中经历6稿修订，结局改动较大。小说以宋哲宗时代为背景，通过宋、辽、大理、西夏、吐蕃等王国之间的武林恩怨和民族矛盾，从哲学的高度对人生和社会进行审视和描写，展示了一幅波澜壮阔的生活画卷。其故事之离奇曲折、涉及人物之众多、历史背景之广泛、武侠战役之庞大、想象力之丰富当属“金书”之最。作品风格宏伟悲壮，是一部写尽人性、悲剧色彩浓厚的史诗巨著。", 65.3, 455));
        books.add(new Book("天龙八部二", "金庸", "《天龙八部》是中国现代作家金庸创作的长篇武侠小说。这部小说从1963年开始创作，历时4年完成。前后共有三版，并在2005年第三版中经历6稿修订，结局改动较大。小说以宋哲宗时代为背景，通过宋、辽、大理、西夏、吐蕃等王国之间的武林恩怨和民族矛盾，从哲学的高度对人生和社会进行审视和描写，展示了一幅波澜壮阔的生活画卷。其故事之离奇曲折、涉及人物之众多、历史背景之广泛、武侠战役之庞大、想象力之丰富当属“金书”之最。作品风格宏伟悲壮，是一部写尽人性、悲剧色彩浓厚的史诗巨著。", 62.4, 678));
        books.add(new Book("天龙八部三", "金庸", "《天龙八部》是中国现代作家金庸创作的长篇武侠小说。这部小说从1963年开始创作，历时4年完成。前后共有三版，并在2005年第三版中经历6稿修订，结局改动较大。小说以宋哲宗时代为背景，通过宋、辽、大理、西夏、吐蕃等王国之间的武林恩怨和民族矛盾，从哲学的高度对人生和社会进行审视和描写，展示了一幅波澜壮阔的生活画卷。其故事之离奇曲折、涉及人物之众多、历史背景之广泛、武侠战役之庞大、想象力之丰富当属“金书”之最。作品风格宏伟悲壮，是一部写尽人性、悲剧色彩浓厚的史诗巨著。", 65.5, 628));
        books.add(new Book("天龙八部四", "金庸", "《天龙八部》是中国现代作家金庸创作的长篇武侠小说。这部小说从1963年开始创作，历时4年完成。前后共有三版，并在2005年第三版中经历6稿修订，结局改动较大。小说以宋哲宗时代为背景，通过宋、辽、大理、西夏、吐蕃等王国之间的武林恩怨和民族矛盾，从哲学的高度对人生和社会进行审视和描写，展示了一幅波澜壮阔的生活画卷。其故事之离奇曲折、涉及人物之众多、历史背景之广泛、武侠战役之庞大、想象力之丰富当属“金书”之最。作品风格宏伟悲壮，是一部写尽人性、悲剧色彩浓厚的史诗巨著。", 62.5, 698));
        books.add(new Book("天龙八部五", "金庸", "《天龙八部》是中国现代作家金庸创作的长篇武侠小说。这部小说从1963年开始创作，历时4年完成。前后共有三版，并在2005年第三版中经历6稿修订，结局改动较大。小说以宋哲宗时代为背景，通过宋、辽、大理、西夏、吐蕃等王国之间的武林恩怨和民族矛盾，从哲学的高度对人生和社会进行审视和描写，展示了一幅波澜壮阔的生活画卷。其故事之离奇曲折、涉及人物之众多、历史背景之广泛、武侠战役之庞大、想象力之丰富当属“金书”之最。作品风格宏伟悲壮，是一部写尽人性、悲剧色彩浓厚的史诗巨著。", 63.2, 688));
        books.add(new Book("天龙八部六", "金庸", "《天龙八部》是中国现代作家金庸创作的长篇武侠小说。这部小说从1963年开始创作，历时4年完成。前后共有三版，并在2005年第三版中经历6稿修订，结局改动较大。小说以宋哲宗时代为背景，通过宋、辽、大理、西夏、吐蕃等王国之间的武林恩怨和民族矛盾，从哲学的高度对人生和社会进行审视和描写，展示了一幅波澜壮阔的生活画卷。其故事之离奇曲折、涉及人物之众多、历史背景之广泛、武侠战役之庞大、想象力之丰富当属“金书”之最。作品风格宏伟悲壮，是一部写尽人性、悲剧色彩浓厚的史诗巨著。", 63.8, 638));
        books.add(new Book("天龙八部七", "金庸", "《天龙八部》是中国现代作家金庸创作的长篇武侠小说。这部小说从1963年开始创作，历时4年完成。前后共有三版，并在2005年第三版中经历6稿修订，结局改动较大。小说以宋哲宗时代为背景，通过宋、辽、大理、西夏、吐蕃等王国之间的武林恩怨和民族矛盾，从哲学的高度对人生和社会进行审视和描写，展示了一幅波澜壮阔的生活画卷。其故事之离奇曲折、涉及人物之众多、历史背景之广泛、武侠战役之庞大、想象力之丰富当属“金书”之最。作品风格宏伟悲壮，是一部写尽人性、悲剧色彩浓厚的史诗巨著。", 47.8, 478));
        books.add(new Book("天龙八部八", "金庸", "《天龙八部》是中国现代作家金庸创作的长篇武侠小说。这部小说从1963年开始创作，历时4年完成。前后共有三版，并在2005年第三版中经历6稿修订，结局改动较大。小说以宋哲宗时代为背景，通过宋、辽、大理、西夏、吐蕃等王国之间的武林恩怨和民族矛盾，从哲学的高度对人生和社会进行审视和描写，展示了一幅波澜壮阔的生活画卷。其故事之离奇曲折、涉及人物之众多、历史背景之广泛、武侠战役之庞大、想象力之丰富当属“金书”之最。作品风格宏伟悲壮，是一部写尽人性、悲剧色彩浓厚的史诗巨著。", 58.9, 578));
        return books;
    }

    /**
     * 获取输入的自定义书籍的信息
     * @return
     */
    private Book Add_book(){
        String name=String.valueOf(add_name.getText());
        String author=String.valueOf(add_author.getText());
        String about=String.valueOf(add_about.getText());
        double price=Double.parseDouble(String.valueOf(add_price.getText()));
        int pages= Integer.parseInt(String.valueOf(add_pages.getText()));
        return new Book(name,author,about,price,pages);
    }

}
