import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    private final Reader reader = new Reader();

    private final static String loremIpsum = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
    private final static String reallyBigText= "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur a massa in magna porta sagittis eu ut orci. Pellentesque consequat felis vel neque vestibulum bibendum. Mauris eu posuere ex. Aliquam id hendrerit justo, et cursus odio. Vivamus ac eleifend leo. Aenean blandit non lectus sed dapibus. Phasellus libero leo, aliquam eget arcu id, semper pharetra sapien. Maecenas elit ligula, semper ullamcorper massa a, pellentesque luctus felis. Sed a maximus ipsum, nec laoreet risus. Praesent tempor efficitur lobortis. Proin id erat ac ligula fermentum pellentesque in in lectus. Quisque ut cursus mauris, quis cursus turpis. Curabitur mollis mi et diam porttitor vehicula.\n" +
            "\n" +
            "Sed nisl lacus, dignissim id urna quis, vulputate placerat velit. Quisque sagittis velit eget eros elementum fringilla. Suspendisse facilisis accumsan ligula eget tristique. Phasellus in posuere lorem. Ut pretium commodo odio, ac eleifend neque. Integer ullamcorper sodales neque. Ut suscipit ullamcorper tellus ornare congue. Duis non semper purus, id condimentum mi. Suspendisse sodales nibh consequat sodales luctus. Maecenas eget dolor vitae mi malesuada tempus. Duis viverra ultrices aliquet. Etiam ut convallis ligula. Nulla sed sapien ac risus pellentesque vehicula. Duis non ante vitae nibh lobortis suscipit.\n" +
            "\n" +
            "Nulla facilisi. Nullam tincidunt, justo ac tempor finibus, lorem nulla pulvinar turpis, id hendrerit ex mauris in velit. Nulla vehicula vitae metus a vulputate. Proin lectus orci, tincidunt eget bibendum eu, sagittis sed ipsum. Sed ante ex, lacinia ut viverra quis, dignissim a nisi. Phasellus pellentesque cursus tortor, malesuada elementum metus volutpat ac. Duis non lorem at mauris condimentum imperdiet eget et magna. Etiam ac aliquet ex. Suspendisse sagittis risus quis volutpat tincidunt.\n" +
            "\n" +
            "Duis lobortis libero leo, quis consectetur augue placerat id. Etiam posuere, ante ac blandit egestas, lectus nisi condimentum purus, blandit imperdiet ex sapien a metus. Nullam interdum aliquam luctus. Etiam eleifend vulputate ante, id pulvinar odio congue elementum. Sed auctor, diam elementum euismod pharetra, libero nibh dictum mauris, ac ornare risus tellus vitae justo. Nulla sem tellus, tristique sit amet sollicitudin volutpat, tempor placerat lorem. Mauris nec ultrices augue. Duis eu magna sed odio semper tristique quis sed erat.\n" +
            "\n" +
            "Etiam quis porta leo. Nulla id suscipit orci. Ut interdum hendrerit nisl non maximus. Vestibulum pellentesque hendrerit urna eleifend consequat. Ut pretium tincidunt tristique. Fusce tempus pellentesque augue, et ultrices mi volutpat in. Cras ante mi, ullamcorper vitae feugiat a, feugiat eget elit. Fusce a convallis tortor. Proin quis augue ut nunc tincidunt egestas. Pellentesque id orci vestibulum, semper erat vel, fermentum ligula. Nam auctor ante nec nunc sodales malesuada. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Curabitur facilisis vehicula sapien vitae fermentum. Donec vitae tempor nunc, id mattis ante. Nam quis tincidunt quam.\n" +
            "\n" +
            "Quisque condimentum tincidunt magna, ut maximus metus mollis sed. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin ac aliquet justo. Donec aliquet pellentesque nulla nec consequat. Vestibulum et dolor id metus euismod rutrum at vel justo. Fusce fermentum vestibulum lorem eu iaculis. Nam nec congue tellus.\n" +
            "\n" +
            "Phasellus pretium enim mauris, eget ornare leo pharetra id. Duis dapibus vel dui ut venenatis. Duis nec porttitor lacus, quis bibendum nisl. Fusce consectetur dui odio, vulputate accumsan leo bibendum sollicitudin. Proin auctor malesuada risus, sed ultrices quam efficitur ac. Aliquam maximus quam non semper feugiat. Vivamus at lectus metus. Nullam et tempus leo. Etiam vitae facilisis ligula. In mattis, massa in bibendum ullamcorper, lacus mauris varius magna, malesuada pretium ipsum tortor ac est. Nullam sit amet accumsan velit. Pellentesque convallis sit amet mi id placerat.\n" +
            "\n" +
            "Sed molestie dolor ut blandit tincidunt. Morbi mattis tellus erat, varius viverra lorem eleifend et. Maecenas ultricies turpis arcu, id condimentum leo vehicula id. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Suspendisse consequat nibh nisl, vitae elementum urna auctor non. Nunc id dui convallis, hendrerit leo sagittis, molestie nulla. Nullam fermentum iaculis consequat. Morbi quis rutrum orci. Sed facilisis, libero quis fermentum faucibus, diam tortor ornare nisl, ut tincidunt lorem risus ac dui. Morbi luctus nulla non felis luctus dapibus. Proin aliquam lacinia ex, cursus tincidunt magna. Nam vitae odio tempus, tincidunt ligula ut, aliquam ligula. Vestibulum sit amet leo nec ipsum malesuada pretium. Aenean sed lacus est. Maecenas eget purus mollis arcu vehicula mollis ut ut ipsum.\n" +
            "\n" +
            "Nam sed nibh purus. Nunc feugiat justo nibh. Mauris mollis in nunc at fringilla. Integer ipsum orci, viverra ut pretium eu, congue sit amet lectus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Praesent dapibus hendrerit nunc, eget suscipit diam consequat sit amet. Fusce vel molestie nibh, at vehicula nisl. Phasellus blandit leo ut faucibus sagittis. Interdum et malesuada fames ac ante ipsum primis in faucibus.\n" +
            "\n" +
            "Donec eget dui in nunc luctus lobortis. Cras semper, lorem a faucibus congue, nisl urna commodo velit, eget tempor odio mi sed lorem. Duis dictum ante ante, in condimentum metus congue vel. Ut luctus purus a eros pharetra lacinia. Fusce ultricies interdum neque id porttitor. Quisque a tempor ex, sed porttitor arcu. Morbi sit amet scelerisque leo. Sed non nisl at nunc pellentesque dictum a sed purus. Duis quis purus ac nibh volutpat feugiat eget at nunc.\n" +
            "\n" +
            "Aliquam sed ipsum quis dolor posuere congue in at orci. Proin id quam dolor. Phasellus in leo at quam cursus dapibus. Vivamus dolor nibh, venenatis a tellus ac, euismod fringilla eros. Ut nec odio faucibus, faucibus eros nec, sagittis mauris. Pellentesque vitae urna laoreet, suscipit lectus ac, pretium nulla. Nulla et erat dignissim sem sodales finibus vitae sed elit. Donec in sollicitudin ante. Suspendisse tempor, quam sit amet pulvinar lacinia, ipsum sem ornare mi, sit amet porta dolor augue in tortor.\n" +
            "\n" +
            "Ut eu vestibulum orci. Mauris malesuada gravida semper. Cras odio justo, finibus et risus sit amet, mollis ultrices purus. Vivamus luctus, odio eu bibendum egestas, mauris dui bibendum nulla, vitae egestas tortor orci nec justo. Sed elementum, nisi et accumsan rhoncus, est nisl iaculis dolor, a gravida felis odio ut ante. Pellentesque condimentum eleifend magna et laoreet. Fusce in quam neque. Mauris accumsan finibus massa, at ultricies nisl. Nulla scelerisque, tellus a pharetra viverra, nisl lorem convallis sem, at sagittis arcu tellus sit amet nunc. Donec imperdiet imperdiet est vel porttitor. Proin dapibus scelerisque ligula quis fermentum. Cras scelerisque nulla a fringilla rhoncus. Morbi tristique vulputate nisl quis eleifend.\n" +
            "\n" +
            "Mauris facilisis quis risus non mollis. Donec ac mauris nisi. Nulla congue at lorem ut tincidunt. Phasellus volutpat ipsum id tempus blandit. Ut efficitur et nunc vel auctor. Nullam purus lorem, ullamcorper sed cursus sit amet, dictum in dolor. Mauris commodo risus sem, varius tincidunt odio feugiat id. Vivamus ut consequat augue. Praesent non quam lobortis, auctor ante in, posuere lectus. Quisque pretium, elit vitae sollicitudin condimentum, massa tortor eleifend nunc, sed euismod ante leo in nibh. Donec euismod ultricies ante quis viverra. Maecenas semper elit libero, in fermentum justo tristique ut.\n" +
            "\n" +
            "Aenean tempor malesuada sapien eu blandit. Fusce vehicula posuere dolor quis venenatis. Vestibulum aliquet nibh leo, ut auctor lectus viverra imperdiet. Mauris elementum turpis elit, at convallis leo facilisis cursus. Cras at nunc commodo, venenatis augue in, condimentum tortor. Morbi fringilla nulla nunc, eu commodo risus tincidunt malesuada. Morbi urna nisi, congue et dui id, rutrum egestas augue. Duis posuere in mauris eu egestas. Ut sagittis ligula nec libero interdum, vel gravida tortor sollicitudin. Etiam non quam tortor. Phasellus ante mauris, malesuada non tellus id, luctus pellentesque ante. Nulla scelerisque vitae ipsum eget consectetur. Vestibulum egestas sem in nunc rutrum feugiat. Nunc bibendum accumsan mauris, et aliquet elit rhoncus eu.\n" +
            "\n" +
            "Quisque suscipit ac turpis eget ullamcorper. Morbi eget ornare elit, id venenatis turpis. Proin id pulvinar velit. Aenean placerat est sapien, at elementum lectus ultrices id. Nunc lobortis, mi ac mollis eleifend, ex mauris aliquet leo, sed faucibus enim mi vel mi. Nullam molestie urna at risus malesuada, vitae finibus massa dapibus. Vestibulum eleifend convallis ipsum vitae auctor. Cras sagittis, est eget iaculis venenatis, libero diam scelerisque ex, id laoreet ante quam vitae ipsum. Proin sollicitudin gravida elit, sodales ultricies urna feugiat condimentum. Vivamus vehicula, nulla in eleifend scelerisque, lacus nulla hendrerit felis, sit amet vestibulum erat mauris id erat. Fusce rutrum urna maximus diam mollis commodo. Integer porta varius nulla, eget sagittis leo pretium et. Nunc quis lectus luctus, mattis diam eu, fermentum nibh. Sed molestie justo sapien, sed semper quam volutpat id. Nullam pellentesque volutpat est a consequat.\n" +
            "\n" +
            "Suspendisse potenti. Integer imperdiet tellus eget mauris tempus auctor. Nulla facilisi. Curabitur felis purus, auctor quis euismod non, sollicitudin eget sem. Morbi pharetra porttitor turpis, vitae dapibus lectus mattis sit amet. Donec elementum suscipit lectus, ut elementum mi mollis et. Morbi eget rutrum ligula.\n" +
            "\n" +
            "Aliquam interdum ex nec libero viverra fermentum. Suspendisse gravida urna placerat, rutrum orci sit amet, consequat dui. Donec sed sodales sapien. Duis semper metus in magna lobortis, quis suscipit ligula finibus. Donec vitae ante pellentesque, bibendum urna id, convallis erat. Vivamus euismod nisl sed lectus tincidunt dignissim volutpat.";

    @BeforeAll
    static void createFiles() {
        try (Writer writer =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new FileOutputStream("myFile.txt"), StandardCharsets.UTF_8
                             )
                     )
        ) {
            writer.write(loremIpsum);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Writer writer =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new FileOutputStream("reallyBigFile.txt"), StandardCharsets.UTF_8
                             )
                     )
        ) {
            writer.write(reallyBigText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Writer writer =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new FileOutputStream("nonUtfFile.txt"), StandardCharsets.ISO_8859_1
                             )
                     )
        ) {
            writer.write(loremIpsum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void textIsCorrect() {
        String result = reader.readAll("myFile.txt");
        assertEquals(loremIpsum, result);
    }

    @Test
    void reallyBigFile() {
        String result = reader.readAll("reallyBigFile.txt");
        assertEquals(reallyBigText, result);
    }

    @Test
    void nonUtfFile() {
        String result = reader.readAll("nonUtfFile.txt", StandardCharsets.ISO_8859_1);
        assertEquals(reallyBigText, result);
    }

    @Test
    void fileDoesNotExist() {
        String result = reader.readAll("nothing.txt");
        assertNull(result);
    }
}